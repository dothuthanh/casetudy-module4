package com.casestudy.service.song;

import com.casestudy.model.Category;
import com.casestudy.model.Song;

import java.util.Optional;

public interface ISongService {
    Iterable<Song> findAll();
    Optional<Song> findById(Long id);
    Song save (Song song);
    void remove(Long id);

}
