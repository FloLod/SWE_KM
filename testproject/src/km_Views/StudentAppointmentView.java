package km_Views;

public class StudentAppointmentView {
	private int studentAppointmentID;
	private StudentView student;
	private ClassView studentClass;
	private AppointmentView appointment;

	public StudentAppointmentView() {
	}

	public StudentAppointmentView(km_Entities.StudentAppointment studentappointment) {
		this.studentAppointmentID = studentappointment.getStudentAppointmentID();
		this.student = new StudentView(studentappointment.getStudent());
		this.studentClass = new ClassView(studentappointment.getStudentClass());
		this.appointment = new AppointmentView(studentappointment.getAppointment());

	}

	public StudentAppointmentView(int studentAppointmentID, StudentView student, ClassView studentClass,
			AppointmentView appointment) {
		super();
		this.studentAppointmentID = studentAppointmentID;
		this.student = student;
		this.studentClass = studentClass;
		this.appointment = appointment;
	}

	public int getStudentAppointmentID() {
		return studentAppointmentID;
	}

	public void setStudentAppointmentID(int studentAppointmentID) {
		this.studentAppointmentID = studentAppointmentID;
	}

	public StudentView getStudent() {
		return student;
	}

	public void setStudent(StudentView student) {
		this.student = student;
	}

	public ClassView getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(ClassView studentClass) {
		this.studentClass = studentClass;
	}

	public AppointmentView getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentView appointment) {
		this.appointment = appointment;
	}

}
