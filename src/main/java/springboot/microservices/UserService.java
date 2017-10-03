package springboot.microservices;

import java.util.Locale;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/us")
public class UserService {

	public UserService() {

	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public String getUser(@RequestParam(value = "id") String id) {

		return id;

	}

}
