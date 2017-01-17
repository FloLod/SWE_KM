package km_Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EducationDiaryList{
	@Id
	private int EducationDiaryList;
	@ManyToOne
	private StudentClass studentClass;
	@ManyToOne
	private Student studentResponsible;
	@OneToMany
	private List<EducationDiary> educationDiary;
	
	public EducationDiaryList(){
		
	}

	public int getEducationDiaryList() {
		return EducationDiaryList;
	}

	public void setEducationDiaryList(int educationDiaryList) {
		EducationDiaryList = educationDiaryList;
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

	public List<EducationDiary> getEducationDiary() {
		return educationDiary;
	}

	public void setEducationDiary(List<EducationDiary> educationDiary) {
		this.educationDiary = educationDiary;
	}

	
	
}