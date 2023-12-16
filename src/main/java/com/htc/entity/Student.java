package com.htc.entity;

import java.util.List;

import org.springframework.lang.NonNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;
	@NonNull
	@Size(min = 3, max = 14, message = "user name should at least 3 and max 14 characters")
	private String studentName;
	@Email
	@NotEmpty
	private String studentEmail;
	@NonNull
	@Size(min = 6, message = "user should enter atleast 6 characters")
	private String studentAddress;


	//Uni-Directional NO need to define mapping in child entity classes. 
	//Only parent table know about mapping.

	//OneToOne(one student has one profile)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="profiletabId", referencedColumnName = "profileId") 
	private Profile profile;

	//ManyToOne 
	//(one student have a only one department but one department have a many students
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="departmenttabId", referencedColumnName = "departmentId")
	private Department department;

	//oneToMany //one student have list of tasks
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId",referencedColumnName = "studentId") 
	private List<Task> task;

	//ManyToMany //Here creating new table
	@ManyToMany(cascade = CascadeType.ALL) private List<Project> project;


	// default constructor
	public Student() {
		super();
	}

	// parameterized constructor
	public Student(long studentId, String studentName, String studentEmail, String studentAddress, Profile profile,
			Department department, List<Task> task, List<Project> project) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
		this.profile = profile;
		this.department = department;
		this.task = task;
		this.project = project;
	}

	// Setters and Getters
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	// toString() method
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentAddress=" + studentAddress + ", profile=" + profile + ", department=" + department
				+ ", task=" + task + ", project=" + project + "]";
	}
}
