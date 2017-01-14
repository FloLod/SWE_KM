package km_Views;

import java.util.Date;

public class AppointmentView{
	private int appointmentID;
	private TextView text;
	private ContentView content;
	private Date start;
	private Date end;
	
	//appointmenttype
	private String appointmentType;
	private String appointmentDescription;
	private int appointmentTypeID;
	
	public AppointmentView(){}
	public AppointmentView(km_Entities.Appointment appointment){}
	
	public AppointmentView(int appointmentID, TextView text, ContentView content, Date start, Date end,
			String appointmentType, String appointmentDescription, int appointmentTypeID) {
		super();
		this.appointmentID = appointmentID;
		this.text = text;
		this.content = content;
		this.start = start;
		this.end = end;
		this.appointmentType = appointmentType;
		this.appointmentDescription = appointmentDescription;
		this.appointmentTypeID = appointmentTypeID;
	}
	
	public km_Entities.AppointmentType parseAppointmentType(){
		return null;
	}
	
	public km_Entities.Appointment parseAppointment(){
		return null;
	}
	
	
	public int getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	public TextView getText() {
		return text;
	}
	public void setText(TextView text) {
		this.text = text;
	}
	public ContentView getContent() {
		return content;
	}
	public void setContent(ContentView content) {
		this.content = content;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	public void setAppointmentDescription(String appointmentDescription) {
		this.appointmentDescription = appointmentDescription;
	}
	public int getAppointmentTypeID() {
		return appointmentTypeID;
	}
	public void setAppointmentTypeID(int appointmentTypeID) {
		this.appointmentTypeID = appointmentTypeID;
	}
	
	
}