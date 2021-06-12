package sistema.advogados.associados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getLogin(Model model){
		
		return "login";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String getIndex(Model model) {
		
		return "index";
	}
}