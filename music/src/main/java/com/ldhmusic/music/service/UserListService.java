package com.ldhmusic.music.service;

import com.ldhmusic.music.entity.UserList;
import com.ldhmusic.music.mapper.UserListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserListService {
    @Autowired
    private UserListMapper userListMapper;
    public List<UserList> selestUserListByUserId(String userId){
        return userListMapper.selectUserList(userId,null);
    }
    public  List<UserList> selectUserListByListId(String userListId){
        return userListMapper.selectUserList(null,userListId);
    }
    public void addNewUserSongList(String userListId,String userListName,String userId,String userListImgUrl){
        userListMapper.addNewUserSongList(userListId,userListName,userId,userListImgUrl);
    }
    public void delUserListById(String userListId){
        userListMapper.delUserListById(userListId);
    }

    public void updateUserListText(String userListText,String userListId){
        userListMapper.updateUserListInfo(null,userListText,null,userListId);
    }
    public void updateUserListName(String userListName,String userListId){
//        System.out.println("service中传过来userlistname"+userListName);
        userListMapper.updateUserListInfo(userListName,null,null,userListId);
    }
}
