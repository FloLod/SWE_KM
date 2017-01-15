package km_Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EducationDiaryList{
	@Id
	private int EducationDiaryList;
	private int week;
	@ManyToOne
	private StudentClass studentClass;
	@ManyToOne
	private Student studentResponsible;
	@ManyToOne
	private EducationDiary educationDiary;
	
	public EducationDiaryList(){
		
	}

	public int getEducationDiaryList() {
		return EducationDiaryList;
	}

	public void setEducationDiaryList(int educationDiaryList) {
		EducationDiaryList = educationDiaryList;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public Student getStudentResponsible() {
		return studentResponsible;
	}

	public void setStudentResponsible(Student studentResponsible) {
		this.studentResponsible = studentResponsible;
	}

	public EducationDiary getEducationDiary() {
		return educationDiary;
	}

	public void setEducationDiary(EducationDiary educationDiary) {
		this.educationDiary = educationDiary;
	}
	
	
}