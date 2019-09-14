package springboot.microservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/us")
public class HelperService {

	//@Value("${basic.authorization}")
    private String personalToken ="Basic dXNlcjpwYXNzd29yZA==";
	
	
	@Value("${host.name}")
    private String hostName ;
	
	public HelperService() {

	}

	@RequestMapping(value = "/getGreet", method = RequestMethod.GET)
	public String getGreet() {

		String url = hostName+"gc/greeting";
		 
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("Authorization", personalToken);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response =template.exchange(url, HttpMethod.GET, request, String.class);
       
        return (response.getBody());

	}
	
	@RequestMapping(value = "/getJsonMap", method = RequestMethod.GET,produces="application/json")
	public Map getJsonMap() { 
		Map<String, Object> subMap = new HashMap<String, Object>();
		subMap.put("subId", 1);
		subMap.put("subResult", "OK");
		 
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("id", 1);
		 map.put("result", "OK");
		 map.put("subMap", subMap);  
		return map;
		
		
	}

}
