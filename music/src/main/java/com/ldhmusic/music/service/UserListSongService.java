package com.ldhmusic.music.service;

import com.ldhmusic.music.entity.UserListSong;
import com.ldhmusic.music.mapper.UserListSongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserListSongService {
    @Autowired
    private UserListSongMapper listSongMapper;
    public List<UserListSong> selectUserListSongsById(String userListId){
        return listSongMapper.selectUserListSongs(userListId,null);
    }
    public int delSongFromList(String userListId,String songId){
        return listSongMapper.delSongFromList(userListId,songId);
    }
    public int addSongToList(String userListId,String songId){
        return listSongMapper.addSongToList(userListId,songId);
    }
    public List<UserListSong> selectUserListSongByListIdAndSongId(String userListId,String songId){
        return listSongMapper.selectUserListSongs(userListId,songId);
    }

}
