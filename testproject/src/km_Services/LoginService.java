package km_Services;

import km_Views.UserView;

public interface LoginService {

	public UserView getLogin(String email, String pw);
}
