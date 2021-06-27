package com.ldhmusic.music.controller;

import com.ldhmusic.music.entity.UserInfo;
import com.ldhmusic.music.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/LookAllUser")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public List<UserInfo> LoginSelect(){
        return userMapper.selectUserInfo();
    }

}
