package springboot.config;

/**
 * Hello world!
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.servcie.GreetingController;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = GreetingController.class)
public class StartUpController {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartUpController.class, args);
	}
}