package springboot.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.dao.PersonService;

@CrossOrigin
@RestController
@RequestMapping("/todo")
public class ToDoListController {
	private final Logger logger = LogManager.getLogger(ToDoListController.class);
	
	@RequestMapping(value = "/createTask", method = RequestMethod.POST , consumes="application/json" ,produces="application/json" )
	public boolean createTask(@RequestBody String  task) throws Exception {
		System.out.println(task);
		logger.error(task);
		try {
			PersonService td=new PersonService();
			int result=td.addTask(task);
			if(result>0) {
				return true; 
			}
		}catch(Exception e) {
			throw e;
		}
		return false;
	}
	
}
