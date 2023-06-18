package com.eXcelerate.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.Lecture;
import com.eXcelerate.entities.Quiz;
import com.eXcelerate.exceptions.AlreadyUpdatedException;
import com.eXcelerate.exceptions.NoAccountLoggedInException;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface ICourseServices {
	Set<Course> showCourses()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;

	List<Assignment> showAssignments()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;

	List<Quiz> showQuizzes() throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;

	List<Lecture> showLectures()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;

	Boolean updateAssignmentStatus(int courseID, int assignmentID, int status) throws NoSuchRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException;

	Boolean updateQuizStatus(int courseID, int quizID, int status) throws NoSuchRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException;

	void updateLectureStatus(int courseID, int lectureID) throws NoSuchRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException;

	Map<String, Double> showStats() throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;

}