package com.ldhmusic.music.mapper;

import com.ldhmusic.music.entity.UserListSong;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserListSongMapper {
    List<UserListSong> selectUserListSongs(String userListId,String songId);
    int delSongFromList(String userListId,String songId);
    int addSongToList(String userListId,String songId);
}
