package springboot.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JSPController {
 
	@RequestMapping(value = "/jsp/{param : .+}", method = RequestMethod.GET)
	public String rootContext(Model model, @PathParam("param") String msg) {
		System.out.println(msg);
		msg = msg.substring(0, (msg.indexOf(".") - 1 > 0 ? msg.indexOf(".") - 1 : msg.length() - 1));
		model.addAttribute("view", msg);

		System.out.println(model.toString() + " from rootcontext");
		return msg;
	}
}