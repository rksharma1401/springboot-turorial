package springboot.config;

import javax.websocket.server.PathParam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableScheduling
@EnableAutoConfiguration
@EnableWebMvc
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

	@RequestMapping(value="/jsp/{param : .+}" , method=RequestMethod.GET)
	public String rootContext(Model model, @PathParam("param") String msg) {
		System.out.println(msg);
		msg = msg.substring(0, (msg.indexOf(".") - 1 > 0 ? msg.indexOf(".") - 1 : msg.length() - 1));
		model.addAttribute("view", msg);

		System.out.println(model.toString() + " from rootcontext");
		return "msg";
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