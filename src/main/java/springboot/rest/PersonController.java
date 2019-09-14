/**
 * 
 */
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
 * @author ravikant.sharma 12-Jan-2017
 */
@RestController
@RequestMapping("/pc")
public class PersonController {
	private final Logger logger = LogManager.getLogger(PersonController.class);
	private org.springframework.context.support.ReloadableResourceBundleMessageSource messageSource;
	@Autowired
	PersonService personService;
	
	

	public PersonController() { 
		ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) StartUpController.context;
		messageSource =  (ReloadableResourceBundleMessageSource) context.getBean("messageSource");
	}
	 
	
	@RequestMapping(value = "/messageSource", method = RequestMethod.GET)
	public String getMessageSource(@RequestHeader(value = "lang", required = false) Locale locale) {
		
		   Object[] args = new Object[]{"askName"};
		String m=messageSource.getMessage("askName", args, locale);
		return m ;
	}
	
	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public Boolean add(@RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname,
			@RequestParam(value = "age") int age, @RequestParam(value = "place") String place,
			@RequestHeader(value = "lang", required = false) Locale locale) {
		
		Boolean isAdded=false;
		
		Person person = new Person();
		person.setFirstName(fname);
		person.setLastName(lname);
		person.setAge(age);
		person.setPlace(place);
		
		if (personService.addPerson(person) > 0) {
			isAdded=true;
			logger.info("Person saved successfully");
		}else{
			isAdded=false;
		}

		
		return isAdded;
	}
	@RequestMapping(value = "/addPersonGet", method = RequestMethod.GET)
	public Boolean addGet(@RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname,
			@RequestParam(value = "age") int age, @RequestParam(value = "place") String place,
			@RequestHeader(value = "lang", required = false) Locale locale) {
		
		Boolean isAdded=false;
		
		Person person = new Person();
		person.setFirstName(fname);
		person.setLastName(lname);
		person.setAge(age);
		person.setPlace(place);
		
		if (personService.addPerson(person) > 0) {
			isAdded=true;
			logger.info("Person saved successfully");
		}else{
			isAdded=false;
		}

		
		return isAdded;
	}
	@RequestMapping(value = "/getPersonByName", method = RequestMethod.GET)
	public List<Person> getPersonByName(@RequestParam(value = "fname") String fname,
			@RequestParam(value = "lname") String lname,
			@RequestHeader(value = "lang", required = false) Locale locale) {
		
		List<Person> lstperson=personService.getPersonByName(fname, lname);
		return lstperson ;
	}
	
	@RequestMapping(value = "/getAllPersons", method = RequestMethod.GET)
	public List<Person> getAllPersons(@RequestHeader(value = "lang", required = false) Locale locale) {
		
		List<Person> lstperson=personService.getAllPerson();
		return lstperson ;
	}
 
	
}
