package com.ldhmusic.music.mapper;

import com.ldhmusic.music.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {
    List<UserInfo> selectUserInfo();

    UserInfo selectUserByID(String userId);
}
