package km_Services;

import km_Views.StudentView;

public interface StudentService {

	public void addStudent(StudentView student);
	
	public void findStudent(int studentid);
	
	public void deleteStudent(int studentid);
	
}
