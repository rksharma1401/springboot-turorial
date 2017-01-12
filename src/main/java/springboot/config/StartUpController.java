package springboot.config;

import javax.annotation.PostConstruct;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages="springboot.servcie,springboot.dao,")
public class StartUpController {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}
	
	

	 
	
	/*@PostConstruct
	public void startDBManager() {
		
		//hsqldb
		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });

		//derby
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:derby:memory:testdb", "--user", "", "--password", "" });

		//h2
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:h2:mem:testdb", "--user", "sa", "--password", "" });

	}*/
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartUpController.class, args);
	}
}