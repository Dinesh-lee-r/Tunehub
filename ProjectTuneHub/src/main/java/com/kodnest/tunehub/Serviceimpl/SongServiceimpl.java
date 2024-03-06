package com.kodnest.tunehub.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.Entity.Song;
import com.kodnest.tunehub.Repository.SongRepository;
import com.kodnest.tunehub.Service.SongService;
@Service
public class SongServiceimpl implements SongService {
	@Autowired
SongRepository songrepository;
	@Override
	public String addSong(Song song) {
		songrepository.save(song);
		return "Song Added Successfully";
		
	}

	@Override
public boolean nameExists(String name) {
	if (songrepository.findByName(name) != null) {
		return true;
	} else {
		return false;
	}
}

	@Override
	public List<Song> fetchAllSongs() {
List<Song> songs=songrepository.findAll();
		return songs;
	}
	@Override
	public void updateSong(Song s) {
		
		songrepository.save(s);
	}}