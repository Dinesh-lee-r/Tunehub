package com.kodnest.tunehub.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.Entity.Playlist;
import com.kodnest.tunehub.Repository.PlaylistRepository;
import com.kodnest.tunehub.Service.PlaylistService;

@Service
public class PlaylistServiceimpl implements PlaylistService{
@Autowired
PlaylistRepository plr;
@Override
public void addplaylist (Playlist playlist) {
	plr.save(playlist);
}
@Override
public List<Playlist> fetchAllPlaylists() {
	List<Playlist> allplaylist=plr.findAll();
	return allplaylist;
}
}
