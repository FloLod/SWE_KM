package km_Services;

import km_Views.EducationDiaryListView;
import km_Views.EducationDiaryView;

public interface ExchangeCenterService {

	public void updloadEducationDiary(EducationDiaryView edv, EducationDiaryListView edl);
	
	public void downloadEducationDiary(EducationDiaryView edv, EducationDiaryListView edl);
	
	public void notifyclass();
	
	
}
