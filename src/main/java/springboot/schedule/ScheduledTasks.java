/**
 * 
 */
package springboot.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import springboot.config.StartUpController;
import springboot.model.Person;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import springboot.config.db.HibernateConnection;

/**
 * @author ravikant.sharma 17-Jan-2017
 */
@Component
@EnableScheduling
public class ScheduledTasks {

	private static final Logger log = LogManager.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private static ApplicationContext context = null;

	@PostConstruct
	public void setUp() {
		log.info("Going to assign context"); 
		context = StartUpController.context;
	}

	/*
	 * @Autowired private ApplicationContext context;
	 */

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		log.info("The time is now " + dateFormat.format(new Date()));
		Person p = (Person) context.getBean("MyBean");
		log.info("Person from context : " + p );

	}

 
	 
	
	@Scheduled(fixedDelayString = "100000")
	public void testDB() throws Exception{
		System.out.println("Query is going to execute");
		Session session=HibernateConnection.getSession();
		Transaction tx=session.beginTransaction();
		SQLQuery  query = session.createSQLQuery("select sysdate() from dual");
		query.list();
		System.out.println("Query Executed");
		tx.commit();  

	}

	@PreDestroy
	public void clear() { }
}