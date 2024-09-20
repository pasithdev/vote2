package com.vote2.api.models;

public class MdlGetDataVote {
    private String photoName;
    private String name;
    private int score;
    private int totalScore;
    private int pId;
    
    public String getPhotoName() {
        return photoName;
    }
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public int getpId() {
        return pId;
    }
    public void setpId(int pId) {
        this.pId = pId;
    }

    
}
