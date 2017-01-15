package km_Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "educationDiaryID")
	private List<EducationDiaryDay> days;
	@ManyToOne
	private EducationDiaryList list;

	public EducationDiary() {
	}
	
	public EducationDiaryList getList() {
		return list;
	}

	public void setList(EducationDiaryList list) {
		this.list = list;
	}

	public List<EducationDiaryDay> getDays() {
		return days;
	}

	public void setDays(List<EducationDiaryDay> days) {
		this.days = days;
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