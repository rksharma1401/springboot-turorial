package springboot.config;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
// @Controller
@ComponentScan(basePackages = "springboot.service,springboot.dao,springboot.rest,springboot.schedule")
public class StartUpController {

	private static String[] springConfig = { "classpath:" + "/spring/context.xml" };
	public static final ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartUpController.class, args);

	}

	@PreDestroy
	public void clear() {
		if (context != null && ((ConfigurableApplicationContext) context).isActive()) {
			((ConfigurableApplicationContext) context).close();
		}
	}

	// @RequestMapping("/")
	// @ResponseBody
	// String home() {
	// return "Hello World!";
	// }

	/*
	 * @PostConstruct public void startDBManager() {
	 * 
	 * //hsqldb DatabaseManagerSwing.main(new String[] { "--url",
	 * "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	 * 
	 * //derby //DatabaseManagerSwing.main(new String[] { "--url",
	 * "jdbc:derby:memory:testdb", "--user", "", "--password", "" });
	 * 
	 * //h2 //DatabaseManagerSwing.main(new String[] { "--url",
	 * "jdbc:h2:mem:testdb", "--user", "sa", "--password", "" });
	 * 
	 * }
	 */
}