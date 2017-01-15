package km_Services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import km_Entities.EducationDiary;
import km_Entities.EducationDiaryDay;
import km_Entities.EducationDiaryList;
import km_Views.ClassView;
import km_Views.EducationDiaryDayView;
import km_Views.EducationDiaryListView;
import km_Views.EducationDiaryView;
import km_Views.StudentView;

public class ExchangeCenterServiceImpl implements ExchangeCenterService {

	PDFService pdf = new PDFServiceImpl();

	@Override
	public void downloadEducationDiary(StudentView sv, EducationDiaryView edv, String filePath)
			throws FileNotFoundException {
		// TODO Auto-generated method stub

		pdf.createPDF(edv, new FileOutputStream(filePath));
	}

	@Override
	public void uploadEducationDiary(EducationDiaryView edv, EducationDiaryListView edl,
			List<EducationDiaryDayView> days) {
		// TODO Auto-generated method stub

		EducationDiary ed = edv.parseEducationDiary();

		ed.setList(edl.parseEducationDiaryList());
		ed.setDays(days.stream().map(day -> day.parseEducationDiaryDay()).collect(Collectors.toList()));

		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();
		em.persist(ed);
		em.getTransaction().commit();

	}

	@Override
	public EducationDiaryListView getEducationDiaries(ClassView cv, Date from, Date until) {
		// TODO Auto-generated method stub
		return getEducationDiaries(cv);
	}

	@Override
	public EducationDiaryListView getEducationDiaries(ClassView cv) {
		// TODO Auto-generated method stub
		return new EducationDiaryListView(EntityManagerFactoryService.getEntityManagerFactory().createEntityManager()
				.createQuery("from km_Entities.EducationDiaryList where studentClass = " + cv.getClassID(),
						EducationDiaryList.class)
				.getSingleResult());
	}

	@Override
	public List<EducationDiaryDayView> getEducationDiary(EducationDiaryView edv) {
		// TODO Auto-generated method stub
		return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager().createQuery(
				"from km_Entities.EducationDiaryDay where educationDiaryID = " + edv.getEducationDiaryID(),
				EducationDiaryDay.class).getResultList().stream().map(day -> new EducationDiaryDayView(day)).collect(Collectors.toList());
	}

}
