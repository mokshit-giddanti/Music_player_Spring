package com.code.musicapi.Crud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// SongController.java
@RestController
@RequestMapping("/songs")
public class SongController {
    private final SongManager songManager;

    public SongController(SongManager songManager) {
        this.songManager = songManager;
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody SongDTO songDTO) {
        Song createdSong = songManager.saveSong(songDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSong);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable Long id) {
        Song song = songManager.getSongById(id);
        return ResponseEntity.ok(song);
    }

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songManager.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songManager.deleteSong(id);
        return ResponseEntity.noContent().build();
    }
}