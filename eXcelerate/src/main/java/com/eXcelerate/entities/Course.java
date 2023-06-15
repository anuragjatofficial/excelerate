package com.eXcelerate.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	@ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
	private Set<Student> students = new HashSet<>();
	private Set<Quiz> quizzes = new HashSet<>();
	@ElementCollection
	@Embedded
	private Set<Assignment> assignments = new HashSet<>();
	private Set<Lectures> lectures = new HashSet<>();	
	private State courseStatus;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName, Set<Student> students, Set<Quiz> quizzes,
			Set<Assignment> assignments, Set<Lectures> lectures,State courseStatus) {
		super();
		this.courseName = courseName;
		this.students = students;
		this.quizzes = quizzes;
		this.assignments = assignments;
		this.lectures = lectures;
		this.courseStatus = courseStatus;
	}



	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public Set<Lectures> getLectures() {
		return lectures;
	}

	public void setLectures(Set<Lectures> lectures) {
		this.lectures = lectures;
	}

	public State getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(State courseStatus) {
		this.courseStatus = courseStatus;
	}
}
