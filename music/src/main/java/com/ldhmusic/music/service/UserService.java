package com.ldhmusic.music.service;

import com.ldhmusic.music.entity.Role;
import com.ldhmusic.music.entity.UserInfo;
import com.ldhmusic.music.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
//public class UserService implements UserDetailsService {
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserInfo> selectUser(){
        return userMapper.selectUserInfo();
    }

    @Transactional
    public UserInfo selectUserByID(String id){

        return userMapper.selectUserByID(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        if (userId == null){
            throw new RuntimeException("用户名不能为空");
        }
        UserInfo userInfo = userMapper.selectUserByID(userId);
        if (userInfo ==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> auths = new ArrayList<>();
        List<Role> roles = userInfo.getRoles();
        System.out.println(userInfo);
        for(Role role:roles){
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(role.getCode());
            auths.add(sga);
        }
//        String encoderPw = passwordEncoder.encode(userInfo.getUserPassword());
//        System.out.println(encoderPw);
        User user = new User(userId,userInfo.getUserPassword(),auths);
        return user;
    }

}
