package km_Services;

import java.util.List;

import km_Entities.StudentClass;
import km_Views.ClassView;
import km_Views.StudentView;

public interface ClassService {
	
	public List<StudentView> getClass(int classID);
	
	public StudentClass getStudentClass(int classID);
	
	public void addClass(int classID);
	
	public void deleteClass(int classID);
	
	public List<ClassView> getClasses();
	
}
