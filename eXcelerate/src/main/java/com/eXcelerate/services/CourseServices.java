package com.eXcelerate.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.eXcelerate.dao.CourseServicesDao;
import com.eXcelerate.dao.ICourseServicesDao;
import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.Lecture;
import com.eXcelerate.entities.Quiz;
import com.eXcelerate.entities.Status;
import com.eXcelerate.exceptions.AlreadyUpdatedException;
import com.eXcelerate.exceptions.NoAccountLoggedInException;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public class CourseServices implements ICourseServices {

	@Override
	public Set<Course> showCourses()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		ICourseServicesDao iCsDao = new CourseServicesDao();

		Set<Course> courses = iCsDao.showCourses();
//		List<String> courselist = new ArrayList<>();
//		for (Course course : courses) {
//			courselist.add(course.getCourseName());
//		}
		return courses;
	}

	@Override
	public List<Assignment> showAssignments()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		ICourseServicesDao iCsDao = new CourseServicesDao();
		return iCsDao.showAssignments();
	}

	@Override
	public List<Quiz> showQuizzes()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		ICourseServicesDao iCsDao = new CourseServicesDao();
		return iCsDao.showQuizzes();
	}

	@Override
	public List<Lecture> showLectures()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		ICourseServicesDao iCsDao = new CourseServicesDao();
		return iCsDao.showLectures();
	}

	@Override
	public Boolean updateAssignmentStatus(int courseID, int assignmentID, int status) throws NoSuchRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException {
		ICourseServicesDao iCsDao = new CourseServicesDao();
		return iCsDao.updateAssignmentStatus(courseID, assignmentID, status);
	}

	@Override
	public Boolean updateQuizStatus(int courseID, int quizID, int status) throws NoSuchRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException {
		ICourseServicesDao iCsDao = new CourseServicesDao();
		return iCsDao.updateQuizStatus(courseID, quizID, status);
	}

	@Override
	public void updateLectureStatus(int courseID, int lectureID) throws NoSuchRecordFoundException,
			SomethingWentWrongException, NoAccountLoggedInException, AlreadyUpdatedException {
		ICourseServicesDao iCsDao = new CourseServicesDao();
		iCsDao.updateLectureStatus(courseID, lectureID);
	}

	@Override
	public Map<String, Double> showStats()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		List<Assignment> assignments = showAssignments();
		List<Quiz> quizzes = showQuizzes();
		List<Lecture> lectures = showLectures();
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
