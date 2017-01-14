package km_Services;

import java.util.List;

import km_Views.StudentView;

public interface ClassService {
	
	public List<StudentView> getClass(int classID);
	
	public void addClass(int classID);
	
	public void deleteClass(int classID);
	
}
