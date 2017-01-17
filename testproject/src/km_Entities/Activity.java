package km_Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activity {
	@Id
	@GeneratedValue
	private int actvityID;
	private String description;
	private int duration;

	public Activity() {

	}

	public Activity(String description, int duration) {
		super();
		this.description = description;
		this.duration = duration;
	}

	public int getActvityID() {
		return actvityID;
	}

	public void setActvityID(int actvityID) {
		this.actvityID = actvityID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}