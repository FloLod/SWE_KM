package km_Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppointmentType{
	@Id
	@GeneratedValue
	private int appointmentTypeID;
	private String name;
	private String description;
	
	public AppointmentType(){
		
	}

	public int getAppointmentTypeID() {
		return appointmentTypeID;
	}

	public void setAppointmentTypeID(int appointmentTypeID) {
		this.appointmentTypeID = appointmentTypeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}