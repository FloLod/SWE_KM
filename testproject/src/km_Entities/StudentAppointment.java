package km_Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentAppointment{
	@Id
	@GeneratedValue
	private int StudentAppointmentID;
	@ManyToOne
	private Student student;
	@ManyToOne
	private StudentClass studentClass;
	@ManyToOne
	private Appointment appointment;
	
	public StudentAppointment(){
		
	}

	public int getStudentAppointmentID() {
		return StudentAppointmentID;
	}

	public void setStudentAppointmentID(int studentAppointmentID) {
		StudentAppointmentID = studentAppointmentID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	
}