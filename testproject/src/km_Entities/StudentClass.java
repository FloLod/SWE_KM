package km_Entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StudentClass{
	@Id
	@GeneratedValue
	private int classID;
	private String educationPath;
	private Date year;
	
	public StudentClass(){}

	public int getClassID() {
		return classID;
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
	
}