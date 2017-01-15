package km_Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EducationDiaryDay{
	@Id
	@GeneratedValue
	private int educationDiaryID;
	private int day;
	@ManyToOne
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