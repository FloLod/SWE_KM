package km_Views;

import java.util.List;
import java.util.stream.Collectors;

public class EducationDiaryListView {
	private List<EducationDiaryView> educationDiaryList;
	private ClassView studentClass;
	private StudentView student;
	
	public EducationDiaryListView(){}
	public EducationDiaryListView(km_Entities.EducationDiaryList diaryList){
		
		this.educationDiaryList = diaryList.getEducationDiary().stream().map(d -> new EducationDiaryView(d)).collect(Collectors.toList());
		this.studentClass = new ClassView(diaryList.getStudentClass());
		this.student = new StudentView(diaryList.getStudentResponsible());
		
	}
	public EducationDiaryListView(List<EducationDiaryView> educationDiaryList, ClassView studentClass, StudentView student) {
		super();
		this.educationDiaryList = educationDiaryList;
		this.studentClass = studentClass;
		this.student = student;
	}

	public List<EducationDiaryView> getEducationDiaryList() {
		return educationDiaryList;
	}
	public void setEducationDiaryList(List<EducationDiaryView> educationDiaryList) {
		this.educationDiaryList = educationDiaryList;
	}
	public ClassView getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(ClassView studentClass) {
		this.studentClass = studentClass;
	}
	public StudentView getStudent() {
		return student;
	}
	public void setStudent(StudentView student) {
		this.student = student;
	}
	
	
}
