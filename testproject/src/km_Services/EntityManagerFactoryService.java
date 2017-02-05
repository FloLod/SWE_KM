package km_Services;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerFactoryService {

		private static EntityManagerFactory emf;
		
		private EntityManagerFactoryService() {}
		
		public static EntityManagerFactory getEntityManagerFactory() {
			if (emf==null){
				emf = Persistence.createEntityManagerFactory("waterfall");
				
			}
			return emf;
		}
		
		@Override
		protected void finalize() {

		}

		
}
