package km_Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import km_Views.ClassView;

@Entity
public class StudentClass implements Serializable{
	@Id
	@GeneratedValue
	private int classID;
	private String educationPath;
	private Date year;
	
	@OneToMany(mappedBy = "studentClass")
	private List<Student> students;

	public StudentClass() {
	}

	public int getClassID() {
		return classID;
	}

	public StudentClass(String educationPath, Date year) {
		super();
		this.educationPath = educationPath;
		this.year = year;
	}

	public StudentClass(ClassView studentClass) {
		classID = studentClass.getClassID();
		educationPath = studentClass.getEducationPath();
		year = studentClass.getYear();
		
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getEducationPath() {
		return educationPath;
	}

	public void setEducationPath(String educationPath) {
		this.educationPath = educationPath;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}