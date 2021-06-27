package com.ldhmusic.music.entity;


import lombok.Data;

@Data
public class UserList {
    private String userListId;
    private String userListName;
    private String userId;
    private String userListText;

    public String getUserListId() {
        return userListId;
    }

    public void setUserListId(String userListId) {
        this.userListId = userListId;
    }

    public String getUserListName() {
        return userListName;
    }

    public void setUserListName(String userListName) {
        this.userListName = userListName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserListText() {
        return userListText;
    }

    public void setUserListText(String userListText) {
        this.userListText = userListText;
    }

    public String getUserListImgUrl() {
        return userListImgUrl;
    }

    public void setUserListImgUrl(String userListImgUrl) {
        this.userListImgUrl = userListImgUrl;
    }

    private String userListImgUrl;

}
