package com.kodnest.tunehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.kodnest.tunehub.Entity.Playlist;
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Integer>{

}
