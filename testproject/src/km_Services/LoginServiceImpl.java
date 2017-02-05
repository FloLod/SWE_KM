package km_Services;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import km_Entities.Admin;
import km_Entities.User;
import km_Views.UserView;

@ManagedBean
@SessionScoped
public class LoginServiceImpl implements LoginService {

	@Override
	@PostConstruct
	public UserView getLogin(String email, String pw) {
		Admin admin = null;
		EntityManagerFactory emf = EntityManagerFactoryService.getEntityManagerFactory();

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("from "+User.class.getName()+" where email = :email");
		q.setParameter("email", email);
		
		Object result = null;
		User u = null;
		try{
			result = q.getSingleResult();
			u = (User) result;
		}catch(Exception e){
			e.printStackTrace();
		}
		try
		{
			Query q1 = em.createQuery("from " + Admin.class.getName() + " where user_userID = :user_userID");
			q1.setParameter("user_userID", u);
			
			admin = (Admin) q1.getSingleResult();
		}catch (Exception e) {
		
		}
		em.close();
		
		UserView uv = new UserView(u);
		if(null != admin)
			uv.setAdmin(true);
		
		if(uv.getPasswort().contentEquals(pw)){
			return uv;
		}
		return null;
	}
}