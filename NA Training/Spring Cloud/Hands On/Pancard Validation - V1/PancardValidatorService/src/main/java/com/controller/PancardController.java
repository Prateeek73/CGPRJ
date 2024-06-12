package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.service.PancardService;

@RestController
@RequestMapping("/validate")
public class PancardController {
    
        @Autowired
        private PancardService pancardService;
            
        @GetMapping("/{pannumber}")
        public boolean validatePancard(@PathVariable String pannumber) {
            return pancardService.validatePancard(pannumber);
        }

}
