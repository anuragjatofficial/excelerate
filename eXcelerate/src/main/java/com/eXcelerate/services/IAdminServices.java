package com.eXcelerate.services;

import java.util.Map;
import java.util.Scanner;

import com.eXcelerate.entities.Course;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface IAdminServices {
	void addCourses(Course course) throws SomethingWentWrongException;

	void assignCoureToStudent(int[] courseIDs,int StudentId)throws SomethingWentWrongException, NoSuchRecordFoundException;

	void deleteCourseById(int courseId)throws SomethingWentWrongException, NoSuchRecordFoundException;

	void deleteStudentById(int studentId) throws SomethingWentWrongException, NoSuchRecordFoundException;

	void deleteInstructorById(int instrucorID)throws SomethingWentWrongException, NoSuchRecordFoundException;

	Map<String, Double> showStats(int courseID)throws SomethingWentWrongException, NoSuchRecordFoundException;
}
