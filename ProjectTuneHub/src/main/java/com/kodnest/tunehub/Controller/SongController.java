package com.kodnest.tunehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.Entity.Song;
import com.kodnest.tunehub.Serviceimpl.SongServiceimpl;

@Controller
public class SongController {
	@Autowired
	SongServiceimpl ssi;

@PostMapping("/addsong")
public String addSong(@ModelAttribute Song song) {
	String name = song.getName();
	boolean status = ssi.nameExists(name);
	if (status == false) {
		ssi.addSong(song);
		System.out.println("Song Added Successfully");
	} else {
		System.out.println("Song Already Exists");
	}
	return "newsong";
}
@GetMapping("/viewsongs")
public String viewsongs(Model model) {
	List<Song> songList = ssi.fetchAllSongs();
	model.addAttribute("Songs", songList);
	return "displaysongs";
}
@GetMapping("/playsongs")
public String playsongs(Model model) {
	boolean premium=false;
	if(premium) {
	List<Song> songList = ssi.fetchAllSongs();
	model.addAttribute("Songs", songList);
	return "displaysongs";
}
	else {
		return "subscriptionform";
	}
}
}