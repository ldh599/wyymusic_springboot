package com.ldhmusic.music.mapper;

import com.ldhmusic.music.entity.UserList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserListMapper {
    List<UserList> selectUserList(String userId,String userListId);
//    List<UserList> selectUserListByListId(String userId,String userListId);
    int addNewUserSongList(String userListId,String userListName,String userId,String userListImgUrl);
    int delUserListById(String userListId);
    int updateUserListInfo(String userListName,String userListText,String userListImgUrl,String userListId);
}
