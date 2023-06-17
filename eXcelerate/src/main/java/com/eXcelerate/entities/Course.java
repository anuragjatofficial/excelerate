package com.eXcelerate.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
	private Set<Student> students = new HashSet<>();
	@ElementCollection
	@Embedded
	private Set<Assignment> assignments = new HashSet<>();
	@ElementCollection
	@Embedded
	private Set<Quiz> quizzes = new HashSet<>();
	@ElementCollection
	@Embedded
	private Set<Lecture> lectures = new HashSet<>();
	@Enumerated(EnumType.STRING)
	private State courseStatus;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
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

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public State getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(State courseStatus) {
		this.courseStatus = courseStatus;
	}

	// getter setters for quiz

	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public Set<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(Set<Lecture> lectures) {
		this.lectures = lectures;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignments, courseId, courseName, courseStatus, lectures, quizzes, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(assignments, other.assignments) && courseId == other.courseId
				&& Objects.equals(courseName, other.courseName) && courseStatus == other.courseStatus
				&& Objects.equals(lectures, other.lectures) && Objects.equals(quizzes, other.quizzes)
				&& Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
	}

}
