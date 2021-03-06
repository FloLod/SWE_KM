package km_Handler;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ValueChangeEvent;

import km_Views.*;
@ManagedBean(name="klassenHandler")
@SessionScoped
public class KlassenHandler implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1729L;
	private ClassView studentClass = new ClassView();
	private NotificationView notification;
	List<ClassView> classes;
	List<StudentView> students;
	private StudentView classspeaker;
	private int date;

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public StudentView getClassspeaker() {
		return classspeaker;
	}

	public void setClassspeaker(StudentView classspeaker) {
		this.classspeaker = classspeaker;
	}

	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocatorBean) {
		this.serviceLocator = serviceLocatorBean;
	}

	public String createClass() {
		
		try{
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			studentClass.setYear(sdf.parse(String.valueOf(date)));
			serviceLocator.getClassService().addClass(studentClass);			
		}catch (Exception e) {
			return "retry";
		}
		return showClasses();
	}

	public String showClasses() {
		try {
			this.setClasses(serviceLocator.getClassService().getClasses());
		} catch (Exception e) {
			e.printStackTrace();
			return "retry";
		}
		return "adminOverview";
	}

	public String selectClass(ClassView studentClass) {
		try{
			this.studentClass = studentClass;
		this.setStudents(serviceLocator.getClassService().getClass(studentClass.getClassID()));
		
		}catch (Exception e) {
			return "retry";
		}
		return "success";
	}
	
	public String selectClassspeaker(){
		
		if (this.getStudents().size() == 0) { classspeaker = new StudentView();
		classspeaker.setUser(new UserView());
		
		return "newStudentforClassspeaker";
		}
		return "selectStudentforClassspeaker";
		
	}
	
	
	public String createClassspeaker(){
		try {
			
			System.out.println(studentClass.getClassID());
			classspeaker.setStudentClass(studentClass);
			serviceLocator.getClassService().createClassspeaker(classspeaker);
		} catch (Exception e) {
			e.printStackTrace();
			return "retry";
		}
		
		return selectClass(studentClass);
	}
	public void classspeakerChanged(ValueChangeEvent e){
		try{
			StudentView student = (StudentView)e.getNewValue();
			
			
			classspeaker = student;
		}
		catch(Exception ex){
			System.out.println("eyyy"+ex);
		}
	}
	
	public String addClasspeaker(){
		try {
			serviceLocator.getClassService().addClassspeaker(classspeaker);
		} catch (Exception e) {
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
	
	private Converter studentViewConverter;
	public Converter getStudentViewConverter() {
		return new Converter() {
			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String value) {
				// TODO Auto-generated method stub
				for (int i = 0; i < students.size(); i++) {
					StudentView r = students.get(i);
					if ((new Integer(r.getStudentID()).toString()).equals(value))
						return r;
				}				
				return null;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				// TODO Auto-generated method stub
				return (new Integer(((StudentView)arg2).getStudentID())).toString();
			}			
		};
	}
	public void setStudentViewConverter(Converter studentViewConverter) {
		this.studentViewConverter = studentViewConverter;
	}
	
	@PostConstruct
	public void init() {
	    classspeaker = new StudentView();
	    classspeaker.setUser(new UserView());
	}

	
	
	
	

}
