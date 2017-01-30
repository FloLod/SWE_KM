package km_Services;

import km_Entities.Student;
import km_Entities.User;
import km_Views.StudentView;
import km_Views.UserView;

public interface StudentService {

	public void addStudent(StudentView student);
	
	public void findStudent(int studentid);
	
	public Student findStudentByUserId(int userid);
	
	public void deleteStudent(int studentid);

	Student findStudentByUser(UserView user);
	
}
