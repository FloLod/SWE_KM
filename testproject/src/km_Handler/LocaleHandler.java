package km_Handler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LocaleHandler implements Serializable{
	
	private String locale;
		
	public String changeLocale() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(null != locale) params.get("locale");
		if("en".equals(locale))
		{
			locale = "de";
		}
		else if("de".equals(locale)) {
			locale = "en";
		}
		else locale = "de";
		
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(locale));
		return null;
	}

	public String getLocale() {
		if (locale == null) {
			locale="de";
		}
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
}