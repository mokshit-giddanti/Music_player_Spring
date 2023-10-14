package com.code.musicapi.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class SongManager {
    private final SongRepository songRepository;

    @Autowired
    public SongManager(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song saveSong(SongDTO songDTO) {
        Song song = new Song();
        song.setTitle(songDTO.getTitle());
        song.setArtist(songDTO.getArtist());
        song.setFilePath(songDTO.getFilePath());
        return songRepository.save(song);
    }

    public Song getSongById(Long id) {
        Optional<Song> songOptional = songRepository.findById(id);
        if (songOptional.isPresent()) {
            return songOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found");
        }
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
