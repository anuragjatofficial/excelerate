package com.eXcelerate.services;

import java.util.List;
import java.util.Set;

import com.eXcelerate.dao.DataServicesDao;
import com.eXcelerate.dao.IDataServicesDao;
import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.Lecture;
import com.eXcelerate.entities.Quiz;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public class DataServices implements IDataServices {

	@Override
	public List<Student> showStudents() throws SomethingWentWrongException, NoSuchRecordFoundException {
		IDataServicesDao iDs = new DataServicesDao();
		return iDs.showStudents();
	}

	@Override
	public List<Course> showCourses() throws SomethingWentWrongException, NoSuchRecordFoundException {
		IDataServicesDao iDs = new DataServicesDao();
		return iDs.showCourses();
	}

	@Override
	public void addAssignment(int courseId, Assignment assignment)
			throws SomethingWentWrongException, NoSuchRecordFoundException {
		IDataServicesDao iDs = new DataServicesDao();
		iDs.addAssignment(courseId,assignment);
	}

	@Override
	public void addQuiz(int courseId, Quiz quiz) throws SomethingWentWrongException, NoSuchRecordFoundException {
			IDataServicesDao iDs = new DataServicesDao();
			iDs.addQuiz(courseId,quiz);
	}

	@Override
	public void addLecture(int courseId, Lecture lecture)
			throws SomethingWentWrongException, NoSuchRecordFoundException {
		IDataServicesDao iDs = new DataServicesDao();
		iDs.addLecture(courseId,lecture);
	}

	@Override
	public Set<Lecture> seeAllLecturesByCourseID(int courseID) throws SomethingWentWrongException, NoSuchRecordFoundException {
		IDataServicesDao iDs = new DataServicesDao();
		return iDs.seeAllLecturesByCourseID(courseID);
	}

	@Override
	public Set<Assignment> seeAllAssignmentsByCourseID(int courseID)
			throws SomethingWentWrongException, NoSuchRecordFoundException {
		IDataServicesDao iDs = new DataServicesDao();
		return iDs.seeAllAssignmentsByCourseID(courseID);
	}

	@Override
	public Set<Quiz> seeAllQuizzesByCourseID(int courseID)
			throws SomethingWentWrongException, NoSuchRecordFoundException {
		IDataServicesDao iDs = new DataServicesDao();
		return iDs.seeAllQuizzesByCourseID(courseID);
	}

}
