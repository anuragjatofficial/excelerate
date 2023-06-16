package com.eXcelerate.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Assignment {
	@Column(nullable = false, unique = true)
	private long assignmentID;
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private Status isCompleted;
	private LocalDate givenAt;
	private LocalDate endAt;
	@Enumerated(EnumType.STRING)
	private State is_deleted;

	public Assignment(long assignmentID, String title, String description, Status isCompleted, LocalDate givenAt,
			LocalDate endAt, State is_deleted) {
		super();
		this.assignmentID = assignmentID;
		this.title = title;
		this.description = description;
		this.isCompleted = isCompleted;
		this.givenAt = givenAt;
		this.endAt = endAt;
		this.is_deleted = is_deleted;
	}

	public Assignment() {
		super();
	}

	public long getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(long assignmentID) {
		this.assignmentID = assignmentID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Status isCompleted) {
		this.isCompleted = isCompleted;
	}

	public LocalDate getGivenAt() {
		return givenAt;
	}

	public void setGivenAt(LocalDate givenAt) {
		this.givenAt = givenAt;
	}

	public LocalDate getEndAt() {
		return endAt;
	}

	public void setEndAt(LocalDate endAt) {
		this.endAt = endAt;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(assignmentID, description, endAt, givenAt, isCompleted, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assignment other = (Assignment) obj;
		return assignmentID == other.assignmentID && Objects.equals(description, other.description)
				&& Objects.equals(endAt, other.endAt) && Objects.equals(givenAt, other.givenAt)
				&& isCompleted == other.isCompleted && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Assignment [assignmentID=" + assignmentID + ", title=" + title + ", description=" + description
				+ ", isCompleted=" + isCompleted + ", givenAt=" + givenAt + ", endAt=" + endAt + "]";
	}
}
