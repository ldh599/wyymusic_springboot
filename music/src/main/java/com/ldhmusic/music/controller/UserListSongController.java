package com.ldhmusic.music.controller;

import com.ldhmusic.music.entity.Song;
import com.ldhmusic.music.entity.UserListSong;
import com.ldhmusic.music.service.UserListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class UserListSongController {
    @Autowired
    private UserListSongService listSongService;
    @RequestMapping("/LookListSong/{userListId}")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public List<UserListSong> UserListSelect(@PathVariable("userListId")String userListId){
        return listSongService.selectUserListSongsById(userListId);
    }
    @RequestMapping("/delSongFromList")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public List<UserListSong> delSongFromList(String userListId, String songId){
        listSongService.delSongFromList(userListId,songId);
        return listSongService.selectUserListSongsById(userListId);
    }
    @RequestMapping("/addSongToList")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public boolean addSongToList(String userListId,String songId){
        if(listSongService.selectUserListSongByListIdAndSongId(userListId,songId).size() != 0){

            return false;
        }
//        System.out.println("根据歌单id和歌曲id查询:"+listSongService.selectUserListSongByListIdAndSongId("5990","12"));
        listSongService.addSongToList(userListId,songId);
        return true;
    }
}
