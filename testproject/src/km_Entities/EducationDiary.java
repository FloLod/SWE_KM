package km_Entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EducationDiary {
	@Id
	@GeneratedValue
	private int educationDiaryID;
	@ManyToOne
	private StudentClass studentClass;
	@ManyToOne
	private Content content;
	private int weeek;
	private Date startDate;
	private Date endDate;

	public EducationDiary() {
	}

	public int getEducationDiaryID() {
		return educationDiaryID;
	}

	public void setEducationDiaryID(int educationDiaryID) {
		this.educationDiaryID = educationDiaryID;
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public int getWeeek() {
		return weeek;
	}

	public void setWeeek(int weeek) {
		this.weeek = weeek;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
}