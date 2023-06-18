package com.eXcelerate.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.CurrentLoggedInID;
import com.eXcelerate.entities.Lecture;
import com.eXcelerate.entities.Quiz;
import com.eXcelerate.entities.State;
import com.eXcelerate.entities.Status;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.AlreadyUpdatedException;
import com.eXcelerate.exceptions.NoAccountLoggedInException;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.utils.EMutils;

public class CourseServicesDao implements ICourseServicesDao {

	@Override
	public Set<Course> showCourses()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		EntityManager em = null;
		try {
			em = EMutils.getEntityManager();
			Student student = em.find(Student.class, CurrentLoggedInID.CurrentLoggedInStudentID);
			if (student == null) {
				throw new NoAccountLoggedInException("oops you forgot to login : ) ");
			}
			Set<Course> courses = student.getCourses();
			if (courses.isEmpty()) {
				throw new NoSuchRecordFoundException("you haven't assinged to any course yet");
			}

//			String showCourses = "SELECT c.courseName FROM Course c where c.courseStatus = :courseStatus";
//			Query qu = em.createQuery(showCourses);
//			qu.setParameter("courseStatus", State.ACTIVE);
//			@SuppressWarnings("unchecked")
//			List<String> courseNames = (List<String>) qu.getResultList();
//			if (courseNames.isEmpty()) {
//				
//			}
			return courses;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<Assignment> showAssignments()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		EntityManager em = null;
		try {
			em = EMutils.getEntityManager();
			Student student = em.find(Student.class, CurrentLoggedInID.CurrentLoggedInStudentID);
			if (student == null) {
				throw new NoAccountLoggedInException("oops you forgot to login : ) ");
			}
			Set<Course> courses = showCourses();
			List<Assignment> assignments = new ArrayList<>();
			for (Course course : courses) {
				assignments.addAll(course.getAssignments());
			}
			if (assignments.isEmpty()) {
				throw new NoSuchRecordFoundException("you have not given any assignments so far");
			}
			return assignments;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<Quiz> showQuizzes()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		EntityManager em = null;
		try {

			Set<Course> courses = showCourses();
			List<Quiz> quizzes = new ArrayList<>();
			for (Course course : courses) {
				quizzes.addAll(course.getQuizzes());
			}
			if (quizzes.isEmpty()) {
				throw new NoSuchRecordFoundException("you have not given any quiz so far");
			}
			return quizzes;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<Lecture> showLectures()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		EntityManager em = null;
		try {
			Set<Course> courses = showCourses();
			List<Lecture> lectures = new ArrayList<>();
			for (Course course : courses) {
				lectures.addAll(course.getLectures());
			}
			if (lectures.isEmpty()) {
				throw new NoSuchRecordFoundException("you have not given any lectures to watch so far");
			}
			return lectures;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Boolean updateAssignmentStatus(int courseID, int assignmentID, int status) throws NoSuchRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException {
		EntityManager em = null;
		EntityTransaction et = null;
		Set<Course> courses = showCourses();
		Course course = courses.stream().filter(c -> c.getCourseId() == courseID).findAny().orElse(null);
		if (course == null) {
			throw new NoSuchRecordFoundException("can't find any course with course ID " + courseID);
		}
		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			course = em.merge(course);
			Set<Assignment> assignments = course.getAssignments();

			// to check late submission
			Boolean late = false;

			// code for deletion validation

			Assignment assignment = assignments.stream().filter(a -> a.getAssignmentID() == assignmentID).findAny()
					.orElse(null);

			// code to check if no assignment is there with this id

			if (assignment == null || assignment.getIs_deleted() == State.DELETED) {
				throw new NoSuchRecordFoundException("can't find any assignment with id " + assignmentID);
			}

			int comp = LocalDate.now().compareTo(assignment.getEndAt());
			if (comp > 0) {
				late = true;
			}
			// for throwing exceptions in repeat updating case

			if (assignment.getIsCompleted() == Status.COMPLETED && status == 2) {
				throw new AlreadyUpdatedException("Assignment is already marked as completed ");
			} else if (assignment.getIsCompleted() == Status.PENDING && status == 1) {
				throw new AlreadyUpdatedException("Assignment is already marked as pending ");
			}

			assignments.stream().filter(a -> a.getAssignmentID() == assignmentID).findFirst().ifPresent(a -> {
				if (a.getIsCompleted() != Status.COMPLETED && status == 2) {
					a.setIsCompleted(Status.COMPLETED);
				} else if (a.getIsCompleted() != Status.PENDING && status == 1) {
					a.setIsCompleted(Status.PENDING);
				}
			});
			et.commit();
			return late;
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Boolean updateQuizStatus(int courseID, int quizID, int status) throws NoSuchRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException {
		EntityManager em = null;
		EntityTransaction et = null;
		Set<Course> courses = showCourses();
		Course course = courses.stream().filter(c -> c.getCourseId() == courseID).findAny().orElse(null);
		if (course == null) {
			throw new NoSuchRecordFoundException("can't find any course with course ID " + courseID);
		}
		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			course = em.merge(course);

			// to check late submission
			Boolean late = false;
			// code for validation

			Set<Quiz> quizzes = course.getQuizzes();

			// to confirm if quiz is deleted or not

			Quiz quiz = quizzes.stream().filter(a -> a.getQuizId() == quizID).findFirst().orElse(null);

			if (quiz == null || quiz.getIs_deleted() == State.DELETED) {
				throw new NoSuchRecordFoundException("can't find any quiz with id " + quizID);
			}
			int comp = LocalDate.now().compareTo(quiz.getEndAt());
			if (comp > 0) {
				late = true;
			}
			if (quiz.getIsCompleted() == Status.COMPLETED && status == 2) {
				throw new AlreadyUpdatedException("Quiz is already marked as completed ");
			} else if (quiz.getIsCompleted() == Status.PENDING && status == 1) {
				throw new AlreadyUpdatedException("Quiz is already marked as pending ");
			}

			quizzes.stream().filter(a -> a.getQuizId() == quizID).findFirst().ifPresent(a -> {
				if (a.getIsCompleted() != Status.COMPLETED && status == 2) {
					a.setIsCompleted(Status.COMPLETED);
				} else if (a.getIsCompleted() != Status.PENDING && status == 1) {
					a.setIsCompleted(Status.PENDING);
				}
			});
			et.commit();
			return late;
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void updateLectureStatus(int courseID, int lectureID) throws NoSuchRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException {
		EntityManager em = null;
		EntityTransaction et = null;
		Set<Course> courses = showCourses();
		Course course = courses.stream().filter(c -> c.getCourseId() == courseID).findAny().orElse(null);
		if (course == null) {
			throw new NoSuchRecordFoundException("can't find any course with course ID " + courseID);
		}
		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			course = em.merge(course);

			// code for validation

			Set<Lecture> lectures = course.getLectures();

			// to confirm if lecture is deleted or not

			Lecture lecture = lectures.stream().filter(a -> a.getLectureId() == lectureID).findFirst().orElse(null);

			if (lecture == null || lecture.getIs_deleted() == State.DELETED) {
				throw new NoSuchRecordFoundException("can't find any lecture with id " + lectureID);
			}

			// to check if lecture is already watched

			if (lecture.getIsWatched() == Status.COMPLETED) {
				throw new AlreadyUpdatedException("Lecture is already wathced ");
			}

			lectures.stream().filter(a -> a.getLectureId() == lectureID).findFirst().ifPresent(a -> {
				if (a.getIsWatched() != Status.COMPLETED) {
					a.setIsWatched(Status.COMPLETED);
				}
			});
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
