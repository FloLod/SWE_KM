package km_Handler;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import km_Views.*;
@ManagedBean(name="klassenHandler")
@SessionScoped
public class KlassenHandler implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1729L;
	private ClassView studentClass;
	private NotificationView notification;
	List<ClassView> classes;
	List<StudentView> students;

	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocatorBean) {
		this.serviceLocator = serviceLocatorBean;
	}

	public String createClass(int id) {
		
		try{
			serviceLocator.getClassService().addClass(id);			
		}catch (Exception e) {
			return "retry";
		}
		return "success";
	}

	public String showClasses() {
		System.out.println("Hallo");
		try {
			this.setClasses(serviceLocator.getClassService().getClasses());
			System.out.println("Succ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fail");
			return "retry";
		}
		System.out.println("Success");
		return "success";
	}

	public String selectClass() {
		try{
		this.setStudents(serviceLocator.getClassService().getClass(studentClass.getClassID()));
		}catch (Exception e) {
			return "retry";
		}
		return "success";
	}

	public ClassView getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(ClassView studentClass) {
		this.studentClass = studentClass;
	}

	public NotificationView getNotification() {
		return notification;
	}

	public void setNotification(NotificationView notification) {
		this.notification = notification;
	}

	public List<ClassView> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassView> classes) {
		this.classes = classes;
	}

	public List<StudentView> getStudents() {
		return students;
	}

	public void setStudents(List<StudentView> students) {
		this.students = students;
	}

	
	
	
	

}
