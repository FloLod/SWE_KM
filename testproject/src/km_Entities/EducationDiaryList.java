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

@Entity
public class EducationDiaryList implements Serializable{
	@Id
	@GeneratedValue
	private int EducationDiaryList;
	@ManyToOne
	@JoinColumn(name = "classID")
	private StudentClass studentClass;
	@ManyToOne
	private Student studentResponsible;
	@OneToMany(mappedBy="educationDiaryID", cascade = CascadeType.ALL)
	private List<EducationDiary> educationDiary;

	public EducationDiaryList() {

	}

	public EducationDiaryList(StudentClass studentClass) {
		super();
		this.studentClass = studentClass;
	}

	public EducationDiaryList(StudentClass studentClass, EducationDiary ed) {
		super();
		this.studentClass = studentClass;
		this.educationDiary = new ArrayList<>();
		this.educationDiary.add(ed);
	}

	public EducationDiaryList(StudentClass studentClass, List<EducationDiary> educationDiary) {
		super();
		this.studentClass = studentClass;
		this.educationDiary = educationDiary;
	}

	public EducationDiaryList(StudentClass studentClass, Student studentResponsible,
			List<EducationDiary> educationDiary) {
		super();
		this.studentClass = studentClass;
		this.studentResponsible = studentResponsible;
		this.educationDiary = educationDiary;
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