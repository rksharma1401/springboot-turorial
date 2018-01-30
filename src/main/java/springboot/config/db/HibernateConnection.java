package springboot.config.db;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import springboot.schedule.ScheduledTasks;

public class HibernateConnection {
	private static final Logger log = LogManager.getLogger(ScheduledTasks.class);
	static Exception ex ;
	static SessionFactory sessionFactory = null;
	static {
		try {
			AnnotationConfiguration configuration = new AnnotationConfiguration();
			configuration.configure("hibernate.cfg.xml");
			log.error("Hibernate Configuration created successfully");
			sessionFactory = configuration.buildSessionFactory();
			log.error("SessionFactory created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception in creating sessionFactory " , e);
			ex =e;
		}

	}

	public HibernateConnection() {
	}

	public static Session getSession() throws Exception {
		try {
		return sessionFactory.getCurrentSession();
		}catch(Exception e) {
			throw ex;
		}
	}

}
