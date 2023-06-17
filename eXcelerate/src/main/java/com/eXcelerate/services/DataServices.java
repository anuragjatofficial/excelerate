package com.eXcelerate.services;

import java.util.List;

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

}
