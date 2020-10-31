package com.casestudy.repository.song;

import com.casestudy.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    }
