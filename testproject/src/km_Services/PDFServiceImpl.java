package km_Services;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import km_Views.ActivityView;
import km_Views.EducationDiaryDayView;
import km_Views.EducationDiaryView;
import km_Views.StudentView;

public class PDFServiceImpl implements PDFService{
	private static Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
	private static Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
	private static Font underline = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.UNDERLINE);
	private static Font tnormal = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);

	private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);
	
	
	
	public void createPDF(EducationDiaryView diary, OutputStream fo) {
		try {
			//TODO: later get student form session
			StudentView student = new StudentView();
			student = (StudentView) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(student);
			Document document = new Document();
			PdfWriter.getInstance(document, fo);
			
			document.open();
	
			//TODO: image File auf serverspeicherort
			try{
			Image logo = Image.getInstance(student.getCompanyPicture().getFileName());
			logo.setAbsolutePosition(10, document.getPageSize().getHeight() -50);
			document.add(logo);
			newline(document);		
			}catch(Exception e){
				newline(document);
			}
			Phrase p = new Phrase("Ausbildungsnachweis ", bold);
			document.add(p);
			p = new Phrase("über die Ausbildungswoche Nr. ", normal);
			document.add(p);
			p = new Phrase(" " + diary.getWeek() + " ", underline);
			document.add(p);
			
			//student specific header
			document.add(generateHeader(student, diary));
			newline(document);		
			
			//weekly work
			document.add(generateBody(diary));
			newline(document);		
			
			//footer for signing
			document.add(createFooter());
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void newline(Document document) throws DocumentException{
		Phrase p = new Phrase("\n", new Font(Font.FontFamily.TIMES_ROMAN, 4));
		document.add(p);
	}
	
	private PdfPTable generateHeader(StudentView student, EducationDiaryView diary) throws DocumentException{
		PdfPTable header = new PdfPTable(10);		
		header.setWidthPercentage(100);
		
		PdfPCell[] cells = new PdfPCell[16];
		float[] relativeWidths = {40f, 60f, 30f, 30f, 90f, 40f, 40f, 40f, 20f, 90f};
		header.setWidths(relativeWidths);

		//row1
		cells[0] = new PdfPCell(new Paragraph("KW Nr. ", tnormal));
		cells[1] = new PdfPCell(new Phrase(new SimpleDateFormat("w").format(diary.getStartDate()), tnormal));
		cells[1].setColspan(2);
		cells[1].setHorizontalAlignment(Element.ALIGN_CENTER);
		cells[2] = new PdfPCell(new Paragraph("vom", tnormal));
		cells[3] = new PdfPCell(new Phrase(new SimpleDateFormat("dd.MM.YYYY").format(diary.getStartDate()), tnormal));
		cells[3].setHorizontalAlignment(Element.ALIGN_CENTER);
		cells[4] = new PdfPCell(new Paragraph("bis zum", tnormal));
		cells[5] = new PdfPCell(new Phrase(new SimpleDateFormat("dd.MM.YYYY").format(diary.getStartDate()), tnormal));
		cells[5].setHorizontalAlignment(Element.ALIGN_CENTER);
		cells[5].setColspan(2);
		cells[6] = new PdfPCell(new Phrase(""+ countYear(diary), tnormal));
		cells[6].setHorizontalAlignment(Element.ALIGN_CENTER);
		cells[7] = new PdfPCell(new Paragraph("Ausbildungsjahr", tnormal));
		
		
		//row2
		cells[8] = new PdfPCell(new Paragraph("Name", tnormal));
		cells[9] = new PdfPCell(new Phrase(student.getUser().getFirstname() + " " + student.getUser().getLastname(), tnormal));
		cells[9].setColspan(4);
		cells[9].setHorizontalAlignment(Element.ALIGN_CENTER);
		cells[10] = new PdfPCell(new Paragraph("Ausbildungsberuf", tnormal));
		cells[10].setColspan(2);
		//TODO: ausbildungsberuf extrahieren
		cells[11] = new PdfPCell(new Phrase("", tnormal));
		cells[11].setHorizontalAlignment(Element.ALIGN_CENTER);
		cells[11].setColspan(3);
		
		//row3
		cells[12] = new PdfPCell(new Paragraph("Ausbildende Abteilung", tnormal));
		cells[12].setColspan(2);
		//TODO: Abteilung extrahieren
		cells[13] = new PdfPCell(new Phrase("", tnormal));
		cells[13].setHorizontalAlignment(Element.ALIGN_CENTER);
		cells[13].setColspan(3);
		cells[14] = new PdfPCell(new Paragraph("Fachrichtung", tnormal));
		cells[14].setColspan(2);
		//TODO: fachrichtung extrahieren
		cells[15] = new PdfPCell(new Phrase("", tnormal));
		cells[15].setHorizontalAlignment(Element.ALIGN_CENTER);
		cells[15].setColspan(3);
		
		for(PdfPCell p : cells){
			p.setBorder(Rectangle.NO_BORDER);
		}
		
		cells[1].setBorder(Rectangle.BOTTOM);
		cells[3].setBorder(Rectangle.BOTTOM);
		cells[5].setBorder(Rectangle.BOTTOM);
		cells[6].setBorder(Rectangle.BOTTOM);
		cells[9].setBorder(Rectangle.BOTTOM);
		cells[11].setBorder(Rectangle.BOTTOM);
		cells[13].setBorder(Rectangle.BOTTOM);
		cells[15].setBorder(Rectangle.BOTTOM);
		
		for(PdfPCell p : cells){
			header.addCell(p);
		}
		return header;
	}
	
	private PdfPTable generateBody(EducationDiaryView diary) throws DocumentException{
		PdfPTable content = new PdfPTable(4);	
		content.setWidthPercentage(100);
		
		List<PdfPCell> cells = new ArrayList<PdfPCell>();
		float[] relativeWidths = {30f, 370f, 50f, 30f};
		content.setWidths(relativeWidths);
		
		//row1
		cells.add(new PdfPCell(new Paragraph("Tag", tnormal)));
		cells.add(new PdfPCell(new Paragraph("Ausgeführte Arbeiten, Unterweisungen, Unterricht in der Berufsschule usw", small)));
		cells.add(new PdfPCell(new Paragraph("Einzelstunden", small)));
		cells.add(new PdfPCell(new Paragraph("Gesamt- stunden", small)));
		
		List<EducationDiaryDayView> days = diary.getDays();
		//rows2-5
		for(int i = 0; i<=4 && i < days.size();i++){
			//TODO: Change to Daymap
			PdfPCell dayname = null;
			switch(i){
			case 0:
				dayname = new PdfPCell(new Paragraph("Montag", normal));
				break;
			case 1:
				dayname = new PdfPCell(new Paragraph("Dienstag", normal));
				break;
			case 2:
				dayname = new PdfPCell(new Paragraph("Mittwoch", normal));
				break;
			case 3:
				dayname = new PdfPCell(new Paragraph("Donnerstag", normal));
				break;
			case 4:
				dayname = new PdfPCell(new Paragraph("Freitag", normal));
				break;
			}
			
			dayname.setRotation(90);
			dayname.setVerticalAlignment(Element.ALIGN_MIDDLE);
			dayname.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cells.add(dayname);
			
			PdfPTable day = new PdfPTable(1);
			PdfPTable hours = new PdfPTable(1);
			double sumhours = 0.0;
			

			EducationDiaryDayView oneday = days.get(i);			
			List<ActivityView> actions = oneday.getActivityViews();
			
			//String daywork = diary.getDays()[i-1].getActivityDescription();
			
			String daywork;
			for(int r = 0;r <=7; r++){
				if(r < actions.size()){
					PdfPCell cell;
					daywork = actions.get(r).getDescription();
					if(daywork.length() >= 120){
						cell = new PdfPCell(new Phrase(daywork.substring(0, 120), small));
					}else{
						cell = new PdfPCell(new Phrase(daywork, small));
					}
					day.addCell(cell);
					
					sumhours = sumhours + actions.get(r).getDuration();
					PdfPCell hour = new PdfPCell(new Phrase(String.valueOf(actions.get(r).getDuration()), small));
					hours.addCell(hour);
				}else{
					day.addCell(new PdfPCell(new Phrase(" ", small)));
					hours.addCell(new PdfPCell(new Phrase(" ", small)));
				}
			}
			
			
			cells.add(new PdfPCell(day));
			cells.add(new PdfPCell(hours));
			
			
			cells.add(new PdfPCell(new Phrase(sumhours + "h",tnormal)));
		}
		
		//TODO: Bemerkungen hinzufügen
		for(PdfPCell p : cells)
		{
				content.addCell(p);
		}
		
		return content;
	}
	
	private PdfPTable createFooter(){
		PdfPTable footer = new PdfPTable(3);
		
		footer.setWidthPercentage(100);
		
		PdfPCell[] cells = new PdfPCell[15];

		PdfPCell emptyleft = new PdfPCell(new Phrase(" ", small));
		emptyleft.setBorder(Rectangle.NO_BORDER);
		emptyleft.setBorder(Rectangle.RIGHT);
		
		PdfPCell emptyright = new PdfPCell(new Phrase(" ", small));
		emptyright.setBorder(Rectangle.NO_BORDER);
		
		
		PdfPCell dateleft = new PdfPCell(new Phrase("Datum: ", small));
		dateleft.setBorder(Rectangle.NO_BORDER);
		dateleft.setBorder(Rectangle.RIGHT);

		PdfPCell dateright = new PdfPCell(new Phrase("Datum: ", small));
		dateright.setBorder(Rectangle.NO_BORDER);
		
		PdfPCell p1 = new PdfPCell(new Phrase("Ich bestätige hiermit die Richtigkeit der Angaben", small));
		PdfPCell p2 = new PdfPCell(new Phrase("Kenntnis genommen:", small));
		PdfPCell p3 = new PdfPCell(new Phrase("Kenntnis genommen:", small));
		PdfPCell p4 = new PdfPCell(new Phrase("Auszubildene/r", small));
		PdfPCell p5 = new PdfPCell(new Phrase("Ausbilder/in der/die mit der Ausbildung Beautragte", small));
		PdfPCell p6 = new PdfPCell(new Phrase("Gesetzlicher Vertreter des/der Auszubildenden", small));
		
		p1.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.TOP);
		p2.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT| Rectangle.TOP);
		p3.setBorder(Rectangle.BOTTOM | Rectangle.TOP);
		p4.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
		p5.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
		p6.setBorder(Rectangle.BOTTOM);
		
		
		cells[0] = new PdfPCell(p1);
		cells[1] = new PdfPCell(p2);
		cells[2] = new PdfPCell(p3);
		cells[3] = new PdfPCell(emptyleft);
		cells[4] = new PdfPCell(emptyleft);
		cells[5] = new PdfPCell(emptyright);
		cells[6] = new PdfPCell(dateleft);
		cells[7] = new PdfPCell(dateleft);
		cells[8] = new PdfPCell(dateright);
		cells[9] = new PdfPCell(emptyleft);
		cells[10] = new PdfPCell(emptyleft);
		cells[11] = new PdfPCell(emptyright);
		cells[12] = new PdfPCell(p4);
		cells[13] = new PdfPCell(p5);
		cells[14] = new PdfPCell(p6);
		
		for(PdfPCell p : cells){
			footer.addCell(p);
		}
		
		return footer;
	}
	
	private int countYear(EducationDiaryView diary){
		int eduyear = 0;
		int syear = diary.getStudentClass().getYear().getYear();
		
		int dyear = diary.getStartDate().getYear();
		int dmonth = diary.getStartDate().getMonth();
		
		eduyear = dyear - syear;
		
		if(dmonth >= 8){
			eduyear++;
		}
		return eduyear;
	}

}
