/**
 * 
 */
package springboot.schedule;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author ravikant.sharma 03-Aug-2017
 */ 
public class ScheduledTasksXML {

	private static final Logger log = LogManager.getLogger(ScheduledTasksXML.class); 

	@PostConstruct
	public void setUp() {
		log.info("Initial setup");
	}

	public void fromXmlBean() {
		log.info("Hello from fromXmlBean  ");

	}

	@PreDestroy
	public void clear() {
		log.info("Going to clear");
	}
}