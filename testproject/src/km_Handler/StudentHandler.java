package km_Handler;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import km_Views.*;

@ManagedBean
@SessionScoped
public class StudentHandler {
	private StudentView student;
	private List<StudentView> students;
	private BlockListView blockStudent;
	private List<BlockListView> blockList;

	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocatorBean) {
		this.serviceLocator = serviceLocatorBean;
	}

	public String createStudent() {
		try {
			serviceLocator.getStudentService().addStudent(student);
		} catch (Exception e) {
			return "retry";
		}

		return "success";
	}

	public String blockStudent() {
		serviceLocator.getStudentService().findStudent(student.getStudentID());
		return null;
	}

	public String overviewStudents() {

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		StudentView student = (StudentView) sessionMap.get("student");
		try {
			students = serviceLocator.getClassService().getClass(student.getStudentClass().getClassID());
		} catch (Exception e) {
			return "retry";
		}
		return "success";
	}

	public String overviewBlocked() {
		return null;
	}

	public void unblockStudent() {
	}

	public String editUser() {
		return null;
	}

	public StudentView getStudent() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		StudentView student = (StudentView) sessionMap.get("student");
		this.student = student;
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