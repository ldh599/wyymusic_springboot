package com.ldhmusic.music.entity;

import lombok.Data;

@Data
public class UserListSong {
    private String userListId;
    private String userId;
    private String songName;
    private String songId;
    private String singerName;
    private String songUrl;

    public String getUserListId() {
        return userListId;
    }

    public void setUserListId(String userListId) {
        this.userListId = userListId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    private String specialName;
}
