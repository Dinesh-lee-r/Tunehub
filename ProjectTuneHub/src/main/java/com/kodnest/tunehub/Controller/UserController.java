package com.kodnest.tunehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.Entity.Song;
import com.kodnest.tunehub.Entity.User;
import com.kodnest.tunehub.Service.SongService;
import com.kodnest.tunehub.Serviceimpl.SongServiceimpl;
import com.kodnest.tunehub.Serviceimpl.UserServiceimpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {


	@Autowired
	UserServiceimpl usi;
	@Autowired
	SongService songService;
	

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user, Model model) {
		String email = user.getEmail();
		boolean status = usi.emailExists(email);
		if (status == false) {
			usi.addUser(user);
			System.out.println("User Added");
		} else {
			
			
			
			
			System.out.println("User Already Exists");
		}
		return "login";
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email")String email,
			@RequestParam("password")String password,HttpSession session, Model model) {
		if(usi.validateUser(email,password)==true){
			String role=usi.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("admin")) {
				return "admin";
			} else {
				User user= usi.getUser(email);
			boolean userstatus=	user.isPremium();
			List<Song> songList=songService.fetchAllSongs();
			model.addAttribute("Songs",songList);
			model.addAttribute("isPremium",userstatus);
				return "customerhome";
				
			}
	

		} else {
			return "login";

		}

	} 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Login";
	}

}