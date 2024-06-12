package com.controller;

import com.jwt.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/myapp")
public class UserController {

    @Autowired
    JwtUtility jwtUtility;

	@GetMapping("/user")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String userDetails() {
          return "You have accessed the user details.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminDetails() {

          return "You have accessed the admin details.";
    }
}
