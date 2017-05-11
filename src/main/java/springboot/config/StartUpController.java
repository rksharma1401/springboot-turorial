package springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
 
@Controller
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan(basePackages="springboot.service,springboot.dao,springboot.rest,springboot.schedule")
public class StartUpController extends SpringBootServletInitializer{

	
	

	 @Override
	    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
	        return application.sources(StartUpController.class);
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