package springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication
@Controller
@ComponentScan(basePackages = "springboot.service,springboot.dao,springboot.rest,springboot.schedule,springboot.controller")
public class StartUpController {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartUpController.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World! -:)";
	}

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