package km_Entities;

public class EducationDiaryDay{
	private int educationDiaryID;
	private int day;
	private Activity activity;
	
	public EducationDiaryDay(){}

	public int getEducationDiaryID() {
		return educationDiaryID;
	}

	public void setEducationDiaryID(int educationDiaryID) {
		this.educationDiaryID = educationDiaryID;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	
}