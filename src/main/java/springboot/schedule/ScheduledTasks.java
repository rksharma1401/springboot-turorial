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
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import springboot.model.Person;

/**
 * @author ravikant.sharma 17-Jan-2017
 */
@Component
public class ScheduledTasks {

	private static final Logger log = LogManager.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private static ConfigurableApplicationContext context = null;

	@PostConstruct
	public void setUp() {
		log.info("Going to create context");
		String[] springConfig = { "classpath:" + "/spring/context.xml" };
		context = new ClassPathXmlApplicationContext(springConfig);
	}

	/*
	 * @Autowired private ApplicationContext context;
	 */

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		log.info("The time is now " + dateFormat.format(new Date()));
	}

	@Scheduled(fixedRate = 50000)
	public void testContext() {
		Person p = (Person) context.getBean("MyBean");
		log.info("Person from context : " + p);

	}

	@PreDestroy
	public void clear() {
		if(context!=null && context.isActive()){
			log.info("Going to close context");
			context.close();
		}
	}
}