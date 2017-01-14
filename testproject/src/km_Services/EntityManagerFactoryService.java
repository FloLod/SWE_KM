package km_Services;

import javax.persistence.EntityManagerFactory;

public class EntityManagerFactoryService {

		private static EntityManagerFactory emf;
		
		private EntityManagerFactoryService() {}
		
		public static EntityManagerFactory getEntityManagerFactory() {
			return emf;
		}
		
		@Override
		protected void finalize() {

		}
		
}
