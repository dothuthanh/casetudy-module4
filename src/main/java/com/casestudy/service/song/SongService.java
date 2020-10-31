package com.casestudy.service.song;

import com.casestudy.model.Category;
import com.casestudy.model.Song;
import com.casestudy.repository.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
    public class SongService implements ISongService{
        @Autowired
        private SongRepository songRepository;
        @Override
        public Iterable<Song> findAll() {
            return songRepository.findAll();
        }

        @Override
        public Optional<Song> findById(Long id) {
            return songRepository.findById(id);
        }

        @Override
        public Song save(Song song) {
            return songRepository.save(song);
        }

        @Override
        public void remove(Long id) {
            songRepository.deleteById(id);
        }
}
