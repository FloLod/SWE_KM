package km_Handler;

import java.util.List;

import javax.faces.bean.ManagedProperty;
import km_Views.*;

public class KalenderHandler {
	private AppointmentView appointment;
	private TimeTableView timetable;
	private StudentAppointmentView studentAppointment;
	private List<AppointmentView> appointments;
	private List<TimeTableView> timetables;
	private List<StudentAppointmentView> studentAppointments;
	
	
	@ManagedProperty("#{serviceLocatorImpl}")
	private ServiceLocator serviceLocator;
	public ServiceLocator getServiceLocator() { return serviceLocator; }
	public void setServiceLocator(ServiceLocator serviceLocatorBean) { this.serviceLocator = serviceLocatorBean; }


	public void like(ContentView content){}
	
	public String overview(){return null;}
	public String selectAppointment(){return null;}
	public String createAppointment(){return null;}
	public String selectTimetable(){return null;}
	public String createTimeTable(){return null;}
	
	public void exportDates(){}
	public AppointmentView getAppointment() {
		return appointment;
	}
	public void setAppointment(AppointmentView appointment) {
		this.appointment = appointment;
	}
	public TimeTableView getTimetable() {
		return timetable;
	}
	public void setTimetable(TimeTableView timetable) {
		this.timetable = timetable;
	}
	public StudentAppointmentView getStudentAppointment() {
		return studentAppointment;
	}
	public void setStudentAppointment(StudentAppointmentView studentAppointment) {
		this.studentAppointment = studentAppointment;
	}
	public List<AppointmentView> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<AppointmentView> appointments) {
		this.appointments = appointments;
	}
	public List<TimeTableView> getTimetables() {
		return timetables;
	}
	public void setTimetables(List<TimeTableView> timetables) {
		this.timetables = timetables;
	}
	public List<StudentAppointmentView> getStudentAppointments() {
		return studentAppointments;
	}
	public void setStudentAppointments(List<StudentAppointmentView> studentAppointments) {
		this.studentAppointments = studentAppointments;
	}
	
	
	
}
