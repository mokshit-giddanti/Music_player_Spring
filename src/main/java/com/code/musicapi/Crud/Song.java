package com.code.musicapi.Crud;

import jakarta.persistence.*;

@Entity
@Table(name = "so")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    //    private int duration;
    private String filePath;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    //    public int getDuration() {
//        return duration;
//    }
//    public void setDuration(int duration) {
//        this.duration = duration;
//    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // Getters and Setters
}