package com.kodnest.tunehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.Entity.Playlist;
import com.kodnest.tunehub.Entity.Song;
import com.kodnest.tunehub.Service.PlaylistService;
import com.kodnest.tunehub.Serviceimpl.SongServiceimpl;

@Controller
public class PlaylistController {
	@Autowired
	SongServiceimpl ssi;
	@Autowired
	PlaylistService pls;
	@GetMapping("/createplaylists")
	public String createPlaylists(Model model) {
		List<Song> songList = ssi.fetchAllSongs();
		model.addAttribute("Songs", songList);
		return "createplaylists";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		//updating playlist table
		pls.addplaylist(playlist);
		//updating song table
		List<Song> songList=playlist.getSongs();
		for (Song s:songList) {
			s.getPlaylists().add(playlist);
			ssi.updateSong(s);
			
		}
	return "admin";
}
	@GetMapping("/viewplaylists")
	public String viewPlaylists(Model model) {
		List<Playlist> allplaylist = pls.fetchAllPlaylists();
		model.addAttribute("playlists", allplaylist);
		return "displayplaylist";
	}
}