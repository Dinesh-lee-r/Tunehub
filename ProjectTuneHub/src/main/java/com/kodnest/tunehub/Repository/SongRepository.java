package com.kodnest.tunehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.tunehub.Entity.Song;
import com.kodnest.tunehub.Entity.User;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer>{

	public Song findByName(String song);

}
