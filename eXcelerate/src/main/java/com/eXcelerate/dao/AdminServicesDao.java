package com.eXcelerate.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.Instructor;
import com.eXcelerate.entities.Lecture;
import com.eXcelerate.entities.Quiz;
import com.eXcelerate.entities.State;
import com.eXcelerate.entities.Status;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.utils.EMutils;

public class AdminServicesDao implements IAdminServicesDao {

	@Override
	public void addCourses(Course course) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();

			et.begin();
			em.persist(course);

			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oops something went wrong please try later ..!");
		} finally {
			if (em != null)
				em.close();
		}
	}

	@Override
	public void assignCoureToStudent(int[] courseIDs, int studentId)
			throws SomethingWentWrongException, NoSuchRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		Student student = findStudentById(studentId);

		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			student = em.merge(student);
			for (int i = 0; i < courseIDs.length; i++) {
				Course course = findCourseById(courseIDs[i]);
				course = em.merge(course);
				student.getCourses().add(course);
			}
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			p.printStackTrace();
			throw new SomethingWentWrongException("oops can't assign courses to database please try later ..!");
		} finally {
			em.close();
		}
	}

	@Override
	public Student findStudentById(int studentId) throws NoSuchRecordFoundException {
		EntityManager em = EMutils.getEntityManager();
		Student student = em.find(Student.class, studentId);
		if (student == null || student.getAccountStatus() == State.DELETED) {
			throw new NoSuchRecordFoundException("can't find any Student with id " + studentId);
		}
		return student;
	}

	@Override
	public Instructor findInstructorById(int instructorId) throws NoSuchRecordFoundException {
		EntityManager em = EMutils.getEntityManager();
		Instructor instructor = em.find(Instructor.class, instructorId);
		if (instructor == null || instructor.getAccountStatus() == State.DELETED) {
			throw new NoSuchRecordFoundException("can't find any Instructor with id " + instructor);
		}
		return instructor;
	}

	@Override
	public Course findCourseById(int courseID) throws NoSuchRecordFoundException {
		EntityManager em = EMutils.getEntityManager();
		Course course = em.find(Course.class, courseID);
		if (course == null || course.getCourseStatus() == State.DELETED) {
			throw new NoSuchRecordFoundException("can't find any course with id " + courseID);
		}
		return course;
	}

	@Override
	public void deleteCourseById(int courseId) throws NoSuchRecordFoundException, SomethingWentWrongException {
		Course course = findCourseById(courseId);
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			course = em.merge(course);
			course.setCourseStatus(State.DELETED);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oops can't delete student please try later");
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteStudentById(int studentId) throws NoSuchRecordFoundException, SomethingWentWrongException {
		Student student = findStudentById(studentId);
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			student = em.merge(student);
			student.setAccountStatus(State.DELETED);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oops can't delete student please try later");
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteInstructorById(int instrucorID) throws NoSuchRecordFoundException, SomethingWentWrongException {
		Instructor instructor = findInstructorById(instrucorID);
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			instructor = em.merge(instructor);
			instructor.setAccountStatus(State.DELETED);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oops can't delete student please try later");
		} finally {
			em.close();
		}
	}

	@Override
	public Map<String, Double> showStats(int courseID) throws NoSuchRecordFoundException, SomethingWentWrongException {
		Course course = findCourseById(courseID);
		Set<Assignment> assignments = course.getAssignments();
		Set<Quiz> quizzes = course.getQuizzes();
		Set<Lecture> lectures = course.getLectures();
		List<Assignment> CompletedAssignments = assignments.stream().filter(a -> a.getIsCompleted() == Status.COMPLETED)
				.collect(Collectors.toList());
		List<Quiz> Completedquizzes = quizzes.stream().filter(a -> a.getIsCompleted() == Status.COMPLETED)
				.collect(Collectors.toList());
		List<Lecture> CompletedLectures = lectures.stream().filter(a -> a.getIsWatched() == Status.COMPLETED)
				.collect(Collectors.toList());

		double assignMentSubmissionRate = Math.round(((CompletedAssignments.size()/assignments.size())*100)*100.00)/100.00;
		double quizzesSubmissionRate = Math.round(((Completedquizzes.size()/quizzes.size())*100)*100.00)/100.00;
		double attendence = Math.round(((CompletedLectures.size()/lectures.size())*100)*100.00)/100.00;
		
		Map<String, Double> stats = new HashMap<>();
		stats.put("assignMentSubmissionRate", assignMentSubmissionRate);
		stats.put("quizzesSubmissionRate", quizzesSubmissionRate);
		stats.put("attendence", attendence);
		return stats;
	}

}
