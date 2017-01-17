package km_Handler;

import java.util.List;

import javax.faces.bean.ManagedProperty;
import km_Views.*;

public class SchuelerHandler {
	private StudentView student;
	private List<StudentView> students;
	private BlockListView blockStudent;
	private List<BlockListView> blockList;
	
	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }
	
	public String createStudent(){return null;}
	public String blockStudent() {return null;}
	public String overviewStudents(){return null;}
	public String overviewBlocked(){return null;}
	public void unblockStudent(){}
	
	public String editUser(){return null;}
	
	
	public StudentView getStudent() {
		return student;
	}
	public void setStudent(StudentView student) {
		this.student = student;
	}
	public List<StudentView> getStudents() {
		return students;
	}
	public void setStudents(List<StudentView> students) {
		this.students = students;
	}
	public BlockListView getBlockStudent() {
		return blockStudent;
	}
	public void setBlockStudent(BlockListView blockStudent) {
		this.blockStudent = blockStudent;
	}
	public List<BlockListView> getBlockList() {
		return blockList;
	}
	public void setBlockList(List<BlockListView> blockList) {
		this.blockList = blockList;
	}
	
	
}
