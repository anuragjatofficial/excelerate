package com.eXcelerate.dao;

import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.Instructor;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface IAdminServicesDao {

	void addCourses(Course course)throws SomethingWentWrongException;

	void assignCoureToStudent(int[] courseIDs, int studentId)throws SomethingWentWrongException, NoSuchRecordFoundException;
	
	Course findCourseById(int courseID)throws NoSuchRecordFoundException;

	Student findStudentById(int studentId)throws NoSuchRecordFoundException;

	void deleteCourseById(int courseId)throws NoSuchRecordFoundException, SomethingWentWrongException;

	void deleteStudentById(int studentId)throws NoSuchRecordFoundException, SomethingWentWrongException;

	Instructor findInstructorById(int instructorId) throws NoSuchRecordFoundException;

}
