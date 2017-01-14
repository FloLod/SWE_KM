package km_Services;

import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;

public interface PDFService{

	public void download();
	
	public void createPDF(HttpServletRequest request, OutputStream os);
}
