/**
 * 
 */
package springboot.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author ravikant.sharma
 * 11-Jan-2017
 */
@Aspect
@Component
public class ServiceMonitor {
 private static final Logger logger = LogManager.getLogger(ServiceMonitor.class);
	
 	@AfterReturning("execution(* springboot.rest..*.*(..))")
	public void logServiceAccessAfter(JoinPoint joinPoint) {
		logger.debug("Completed: " + joinPoint);
//		System.out.println("Completed: " + joinPoint);
	}
 	
 	@Before("execution(* springboot.rest..*.*(..))")
	public void logServiceAccessBefore(JoinPoint joinPoint) {
		logger.debug("started: " + joinPoint);
//		System.out.println("stated: " + joinPoint);
	}

}