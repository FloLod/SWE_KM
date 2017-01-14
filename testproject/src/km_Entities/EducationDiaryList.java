package km_Entities;

public class EducationDiaryList{
	private int EducationDiaryList;
	private int week;
	private StudentClass studentClass;
	private Student studentResponsible;
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