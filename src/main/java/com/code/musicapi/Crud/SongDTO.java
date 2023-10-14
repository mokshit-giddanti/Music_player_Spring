package com.code.musicapi.Crud;

public class SongDTO {
    private String title;
    private String artist;
    //    private int duration;
    private String filePath;
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