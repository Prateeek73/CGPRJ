package controller;

import model.Advertisement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdvertisementController {
	
	@RequestMapping(value="/getdetails")
	String getAdvertisementpage(Advertisement aobj)
	{
		return "advertisement";
	}
	
	@RequestMapping(value="/display")
	String displayAdvertisementDetails(Advertisement aobj, Model model)
	{
	    String advertisementtype = aobj.getAdvertisementType();
	    model.addAttribute("advertisementtype", advertisementtype);
		return "success";
	}
}
