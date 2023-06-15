package com.eXcelerate.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Embeddable
public class Assignment {
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private Status isCompleted;
	private LocalDate givenAt;
	private LocalDate endAt;

	public Assignment(String title, String description, Status isCompleted, LocalDate givenAt, LocalDate endAt) {
		super();
		this.title = title;
		this.description = description;
		this.isCompleted = isCompleted;
		this.givenAt = givenAt;
		this.endAt = endAt;
	}

	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
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
		return Objects.hash(description, endAt, givenAt, isCompleted, title);
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
		return Objects.equals(description, other.description) && Objects.equals(endAt, other.endAt)
				&& Objects.equals(givenAt, other.givenAt) && isCompleted == other.isCompleted
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Assignment [title=" + title + ", description=" + description + ", isCompleted=" + isCompleted
				+ ", givenAt=" + givenAt + ", endAt=" + endAt + "]";
	}
}
