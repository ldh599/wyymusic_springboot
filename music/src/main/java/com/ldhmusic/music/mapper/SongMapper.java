package com.ldhmusic.music.mapper;

import com.ldhmusic.music.entity.Song;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SongMapper {
    List<Song> findAllSong();
    List<Song> selectUserLikeSongsByUserId(String userId);
    int addLikeSong(String userId,String songId);
    int delLikeSong(String userId,String songId);


}
