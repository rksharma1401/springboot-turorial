package springboot.controller;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc 
public class JSPController extends WebMvcConfigurerAdapter {

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
 
	@RequestMapping(value = "/jsp", method = RequestMethod.GET) ///{param : .+}
	public String rootContext(Model model) { //, @PathParam("param") String msg
//		System.out.println(msg);
//		msg = msg.substring(0, (msg.indexOf(".") - 1 > 0 ? msg.indexOf(".") - 1 : msg.length() - 1));
//		model.addAttribute("view", msg);
		model.addAttribute("view", "home");
		System.out.println(model.toString() + " from rootcontext");
		return "home";
	}
}