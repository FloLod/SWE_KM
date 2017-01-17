package km_Views;

import java.util.List;
import java.util.stream.Collectors;

public class EducationDiaryDayView {
	private int educationDiaryID;
	private int dayID;

	// activity
	private List<ActivityView> activityViews;

	public EducationDiaryDayView() {
	}

	public EducationDiaryDayView(km_Entities.EducationDiaryDay educationDiaryDay) {
		this.educationDiaryID = educationDiaryDay.getEducationDiaryID().getEducationDiaryID();
		this.dayID = educationDiaryDay.getDay();
		this.activityViews = educationDiaryDay.getActivity().stream().map(a -> new ActivityView(a))
				.collect(Collectors.toList());

	}

	public EducationDiaryDayView(int educationDiaryID, int dayID, List<ActivityView> activityViews) {
		super();
		this.educationDiaryID = educationDiaryID;
		this.dayID = dayID;
		this.activityViews = activityViews;
	}

	public km_Entities.EducationDiaryDay parseEducationDiaryDay() {
		return null;
	}

	public km_Entities.Activity parseActivity() {
		return null;
	}

	public int getEducationDiaryID() {
		return educationDiaryID;
	}

	public void setEducationDiaryID(int educationDiaryID) {
		this.educationDiaryID = educationDiaryID;
	}

	public int getDayID() {
		return dayID;
	}

	public void setDayID(int dayID) {
		this.dayID = dayID;
	}

	public List<ActivityView> getActivityViews() {
		return activityViews;
	}

	public void setActivityViews(List<ActivityView> activityViews) {
		this.activityViews = activityViews;
	}

}
