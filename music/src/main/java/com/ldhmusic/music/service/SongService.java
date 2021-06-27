package com.ldhmusic.music.service;

import com.ldhmusic.music.entity.Song;
import com.ldhmusic.music.mapper.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    SongMapper songMapper;
    public List<Song> findAllSong(){
//        System.out.println(songMapper.findAllSong());
        return songMapper.findAllSong();
    }
    public List<Song> selectUserLikeSongsByUserId(String userId){
        return songMapper.selectUserLikeSongsByUserId(userId);
    }
    public int addLikeSong(String userId,String songId){
        return songMapper.addLikeSong(userId,songId);
    }
    public int delLikeSong(String userId,String songId){
        return songMapper.delLikeSong(userId,songId);
    }


}
