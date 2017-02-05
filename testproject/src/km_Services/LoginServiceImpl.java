package km_Services;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import km_Entities.User;
import km_Views.UserView;

@ManagedBean
@SessionScoped
public class LoginServiceImpl implements LoginService {

	@Override
	@PostConstruct
	public UserView getLogin(String email, String pw) {
		// TODO Auto-generated method stub
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
		
		em.close();
		UserView uv = new UserView(u);
		
		if(uv.getPasswort().contentEquals(pw)){
			return uv;
		}
		return null;
	}
}