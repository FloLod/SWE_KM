package km_Services;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;

import km_Entities.User;
import km_Views.UserView;

public class LoginServiceImpl implements LoginService {

	@Override
	public UserView getLogin(String email, String pw) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = EntityManagerFactoryService.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Query q = (Query) em.createQuery("from user where email = :email");
		q.setParameter(":email", email);
		em.close();
		Object result = null;
		User u = null;
		try{
			result = q.uniqueResult();
			u = (User) result;
		}catch(Exception e){
			e.printStackTrace();
		}
		UserView uv = new UserView(u);
		if(uv.getPasswort()==pw){
			return uv;
		}
		return null;
	}
}