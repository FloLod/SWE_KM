package km_Services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import km_Entities.Notification;
import km_Entities.NotificationType;
import km_Entities.Text;
import km_Entities.User;
import km_Views.NotificationView;
import km_Views.TextView;
import km_Views.UserView;

public class NotificationServiceImpl implements NotificationService {

	@Override
	public void sendNotification(UserView user, NotificationView nfv) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();
		em.persist(new Notification(
				(User) em
						.createQuery("from km_Entities.User where student = " + user.getUserId())
						.getSingleResult(),
				(NotificationType) em.createQuery(
						"from km_Entities.NotificationType where notificationTypeID =" + nfv.getNotificationTypeID())
						.getSingleResult(),
				new Text(nfv.getText().getHeading(), nfv.getText().getText())));
		em.getTransaction().commit();
	}

	@Override
	public List<NotificationView> getNotifications(UserView user) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();

		return em
				.createQuery("from km_Entities.Notification where student=" + user.getUserId(),
						Notification.class)
				.getResultList().stream()
				.map(not -> new NotificationView(not.getNotificationID(), user, new TextView(not.getText()),
						not.getNotificationType().getName(), not.getNotificationType().getNotificationTypeID()))
				.collect(Collectors.toList());
	}

}
