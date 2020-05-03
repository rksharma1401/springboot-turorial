package springboot.rest;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.dao.ToDoListService;

@RestController
@RequestMapping("/todo")
public class ToDoListController {
	private final Logger logger = LogManager.getLogger(ToDoListController.class);
	@Autowired
	ToDoListService toDoListService;

	@RequestMapping(value = "/createTask", method = RequestMethod.POST)
	public boolean createTask(@RequestBody String task) throws Exception {
		System.out.println(task);
		logger.error(task);
		try {
			int result = toDoListService.addTask(task);
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			throw e;
		}
		return false;
	}
	
	@RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
	public boolean deleteTask(@RequestBody String task) throws Exception {
		System.out.println(task);
		logger.error(task);
		try {
			int result = toDoListService.deleteTask(task);
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			throw e;
		}
		return false;
	}

	@RequestMapping(value = "/getAllTask", method = RequestMethod.GET)
	public List<String> createTask() throws Exception {

		try {
			List<String> result = toDoListService.getAllTask(); 
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

}
