package km_Services;

import java.io.OutputStream;

import km_Views.EducationDiaryView;

public interface PDFService{
	
	public void createPDF(EducationDiaryView diary, OutputStream os, String fachrichtung, String abteilung);
}
