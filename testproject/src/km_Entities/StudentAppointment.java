package km_Entities;

public class StudentAppointment{
	private int StudentAppointmentID;
	private Student student;
	private StudentClass studentClass;
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