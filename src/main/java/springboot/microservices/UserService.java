package springboot.microservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/us")
public class UserService {

	@Value("${basic.authorization}")
    private String personalToken ;
	
	
	@Value("${host.name}")
    private String hostName ;
	
	public UserService() {

	}

	@RequestMapping(value = "/getGreet", method = RequestMethod.GET)
	public String getUser() {

		String url = hostName+"gc/greeting";
		 
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("Authorization", personalToken);
 
        // ignore result because just testing connectivity
        HttpEntity<String> request = new HttpEntity<String>(headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response =template.exchange(url, HttpMethod.GET, request, String.class);
       
        return (response.getBody());

	}

}
