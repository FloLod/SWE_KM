package km_Services;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

	@Override
	public Boolean getAdmin(UserView user) {
		EntityManager em = EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<Admin> query = em.createQuery("from km_Entities.Admin a where a.user.userID=:user", Admin.class);
		
		query.setParameter("user", user.getUserId());
		try{
			Admin a = query.getSingleResult();
			if (a != null) return true;
		
		}catch (NoResultException e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}
}