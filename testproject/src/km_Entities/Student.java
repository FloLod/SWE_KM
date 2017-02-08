package km_Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student implements Serializable{
	@Id
	@GeneratedValue
	private int studentID;
	private int karma;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private User user;
	@ManyToOne
	private StudentClass studentClass;
	@OneToOne(cascade = CascadeType.ALL)
	private File companyPicture;
	private boolean classSpeaker;
	@OneToMany(mappedBy = "creatorStudent", cascade = CascadeType.ALL)
	private List<Content> contents;
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<StudentAppointment> appointments;
//	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//	private List<Like> likes;
	public Student(){
		contents = new ArrayList<>();
	}

	
	public Student(int karma, User user, StudentClass studentClass, File companyPicture, boolean classSpeaker) {
		super();
		this.karma = karma;
		this.user = user;
		this.studentClass = studentClass;
		this.companyPicture = companyPicture;
		this.classSpeaker = classSpeaker;
	}


	public boolean isClassSpeaker() {
		return classSpeaker;
	}


	public void setClassSpeaker(boolean classSpeaker) {
		this.classSpeaker = classSpeaker;
	}


	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public File getCompanyPicture() {
		return companyPicture;
	}

	public void setCompanyPicture(File companyPicture) {
		this.companyPicture = companyPicture;
	}


	public List<Content> getContents() {
		return contents;
	}


	public void setContents(List<Content> contents) {
		this.contents = contents;
	}


	public List<StudentAppointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(List<StudentAppointment> appointments) {
		this.appointments = appointments;
	}

	
	
}