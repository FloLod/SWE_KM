package km_Services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import km_Entities.Notification;
import km_Views.NotificationView;
import km_Views.StudentView;
import km_Views.TextView;
import km_Views.UserView;

public class NotificationServiceImpl implements NotificationService {

	@Override
	public void sendNotification(UserView user, NotificationView nfv) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();
		em.persist(nfv.parseNotification());
		em.getTransaction().commit();
	}

	@Override
	public List<NotificationView> getNotifications(StudentView student) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

		return em
				.createQuery("from km_Entities.Notification where student=" + student.getStudentID(),
						Notification.class)
				.getResultList().stream()
				.map(not -> new NotificationView(not.getNotificationID(), student, new TextView(not.getText()),
						not.getNotificationType().getName(), not.getNotificationType().getNotificationTypeID()))
				.collect(Collectors.toList());
	}

}
