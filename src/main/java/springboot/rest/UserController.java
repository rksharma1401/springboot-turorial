package springboot.rest;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.config.StartUpController;
import springboot.dao.PersonService;
import springboot.model.Person;
import springboot.model.User;
import springboot.service.UserLoginService;

/**
 * @author ravikant.sharma 20-09-2019
 */
@RestController
@RequestMapping("/user")
public class UserController {
	private final Logger logger = LogManager.getLogger(UserController.class);
	



@RequestMapping(value = "/createUser", method = RequestMethod.POST , consumes="application/json" ,produces="application/json" )
	public User createUser(@RequestBody User u) throws Exception {
		System.out.println(u.getCompany() + u.getName() + u.getPost() );
		try {
		u=UserLoginService.createUser(u);
		}catch(Exception e) {
			throw e;
		}
		return u;
	}
	@RequestMapping(value = "/isValid", method = RequestMethod.GET  ,produces="application/json")
	public User isValid(@RequestParam(value = "id") int id) throws Exception {
		User validUser=null;
		try {
			validUser=UserLoginService.isValid(id);
		}catch(Exception e) {
			throw e;
		}
		return validUser;
	}

}