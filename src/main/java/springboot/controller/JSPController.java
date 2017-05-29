package springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc 
@EnableAutoConfiguration
public class JSPController extends WebMvcConfigurerAdapter {

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
 
	@RequestMapping(value = "/jsp", method = RequestMethod.GET) ///{param : .+}
	public String rootContext(Model model) { //, @PathParam("param") String msg
		model.addAttribute("view", "home");
		System.out.println(model.toString() + " from rootcontext");
		return "home";
	}
}