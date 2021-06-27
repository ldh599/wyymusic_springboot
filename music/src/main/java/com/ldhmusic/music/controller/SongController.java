package com.ldhmusic.music.controller;

import com.ldhmusic.music.entity.Song;
import com.ldhmusic.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
public class SongController {
    @Autowired
    SongService songService;
    @RequestMapping("/findFiveSong")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public List<Song> findFiveSong(String userId){
        List<Song> list = songService.findAllSong();
        List<Song> list1 = new ArrayList<>();
        Random random = new Random();
        for(int i = 0;i < 5;i++){
            int n = random.nextInt(list.size());
            list1.add(list.get(n));
            list.remove(n);
        }
        return list1;
    }
    @RequestMapping("/selectUserLikeSongs")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public List<Song> selectUserLikeSongsByUserId(String userId){
        return songService.selectUserLikeSongsByUserId(userId);
    }

    @RequestMapping("/addLikeSong")
    @ResponseBody
//    @PreAuthorize("hasRole('user')")
    public List<Song> addLikeSong(String userId,String songId){
//        System.out.println(userId);
//        System.out.println(songId);
        songService.addLikeSong(userId,songId);
        return songService.selectUserLikeSongsByUserId(userId);
    }
    @RequestMapping("/delLikeSong")
    @ResponseBody
//    @PreAuthorize("hasRole('user')")
    public List<Song> delLikeSong(String userId,String songId){
        songService.delLikeSong(userId,songId);
        return songService.selectUserLikeSongsByUserId(userId);
    }


}
