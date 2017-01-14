package km_Services;

import java.util.List;
import km_Views.AppointmentView;

public interface CalenderService {

	public List<AppointmentView> getOverview();
	
	public AppointmentView getAppointment(int id);
 	
	public void updateAppointment(AppointmentView appo);
	
	public void deleteAppointment(AppointmentView appo);
	
}
