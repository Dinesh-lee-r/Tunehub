package com.kodnest.tunehub.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginRegistrationController {
	 @GetMapping("/Login")
	    public String Login() {
	        return "Login";
	    }

    @GetMapping("/Registration")
    public String Registration() {
        return "Registration";
    }
}