package com.eXcelerate.services;

import java.util.List;

import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.Lecture;
import com.eXcelerate.entities.Quiz;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface IDataServices {
	List<Student> showStudents() throws SomethingWentWrongException, NoSuchRecordFoundException;

	List<Course> showCourses() throws SomethingWentWrongException, NoSuchRecordFoundException;

	void addAssignment(int courseId, Assignment assignment)throws SomethingWentWrongException, NoSuchRecordFoundException;

	void addQuiz(int courseId, Quiz quiz)throws SomethingWentWrongException, NoSuchRecordFoundException;

	void addLecture(int courseId, Lecture lecture)throws SomethingWentWrongException, NoSuchRecordFoundException;;
}
