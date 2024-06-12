package controller;


import org.springframework.ui.Model;
//
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController {

	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String printMessage(Model model)
	{   
	    model.addAttribute("message","Welcome to Spring MVC");
		return "message";
	}
}
