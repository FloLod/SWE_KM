package km_Views;


public class ActivityView {
	

	private int actvityID;
	private String description;
	private int duration;
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
	public ActivityView(int actvityID, String description, int duration) {
		super();
		this.actvityID = actvityID;
		this.description = description;
		this.duration = duration;
	}
	public ActivityView() {
	}

}
