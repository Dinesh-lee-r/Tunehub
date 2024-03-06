package com.kodnest.tunehub.Service;

import java.util.List;

import com.kodnest.tunehub.Entity.Song;

public interface SongService {

	public String addSong(Song song);
public List<Song> fetchAllSongs();
	public boolean nameExists(String name);
	void updateSong(Song s);

}
