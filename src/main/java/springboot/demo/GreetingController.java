/**
 * 
 */
package springboot.demo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ravikant.sharma 10-Jan-2017
 */
@RestController
@RequestMapping("/rest")
public class GreetingController {

	@Autowired
	GreetingService greetingService;
 
	@RequestMapping(value="/")
	public String info(){
		return "This is rest service using spring boot";
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,
			@RequestHeader(value="lang",required=false) Locale locale) { 
		
		if(locale!=null && !greetingService.getLocale().equals(locale)){ 
			greetingService.setLocale(locale); 
		}

		return greetingService.greet(name);
	}
	
	
	@RequestMapping(value = "/askName", method = RequestMethod.GET)
	public String askName(@RequestHeader(value="lang",required=false) Locale locale) { 
		
		if(locale!=null && !greetingService.getLocale().equals(locale)){ 
			greetingService.setLocale(locale); 
		}

		return greetingService.askName();
	}
}