package km_Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EducationDiary {
	@Id
	@GeneratedValue
	private int educationDiaryID;
	@ManyToOne
	private StudentClass studentClass;
	@OneToOne(cascade = CascadeType.ALL)
	private Content content;
	private int weeek;
	private Date startDate;
	private Date endDate; 
	
	@OneToMany(mappedBy = "educationDiaryID", cascade = CascadeType.ALL)
	private List<EducationDiaryDay> days;
	@ManyToOne
	private EducationDiaryList list;

	public EducationDiary() {
	}
	
	public EducationDiary(StudentClass studentClass, Content content, int weeek, Date startDate, Date endDate,
			List<EducationDiaryDay> days, EducationDiaryList list) {
		super();
		this.studentClass = studentClass;
		this.content = content;
		this.weeek = weeek;
		this.startDate = startDate;
		this.endDate = endDate;
		this.days = days;
		this.list = list;
	}

	public EducationDiary(int educationDiaryID, StudentClass studentClass, Content content, int weeek, Date startDate,
			Date endDate, List<EducationDiaryDay> days, EducationDiaryList list) {
		super();
		this.educationDiaryID = educationDiaryID;
		this.studentClass = studentClass;
		this.content = content;
		this.weeek = weeek;
		this.startDate = startDate;
		this.endDate = endDate;
		this.days = days;
		this.list = list;
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