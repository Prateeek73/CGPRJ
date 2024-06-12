package com.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class PancardService {
	
	
	public boolean validatePancard(String pannumber)
	{
	    if (pannumber == null || pannumber.length() != 10) {
	       return false;
	    }
	    
	   
	   String firstFiveChars = pannumber.substring(0, 5);
	   if (!firstFiveChars.matches("[A-Z]+")) {
	     return false;
	   }
	                            
	                                    
	  String nextFourChars = pannumber.substring(5, 9);
	  if (!nextFourChars.matches("[0-9]+")) {
	       return false;
	  }
	                                                    
	                                                            
	  char lastChar = pannumber.charAt(9);
	  if (!Character.isUpperCase(lastChar)) {
	    return false;
	   }
	                                                                    
	                                                                            
	   return true;
	}
}