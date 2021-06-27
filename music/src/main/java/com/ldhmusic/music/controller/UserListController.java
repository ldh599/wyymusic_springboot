package com.ldhmusic.music.controller;

import com.ldhmusic.music.entity.UserList;
import com.ldhmusic.music.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserListController {
    @Autowired
    private UserListService userListService;
    @RequestMapping("/selectUserAllList/{userId}")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public List<UserList> selectUserAllList(@PathVariable("userId")String userId){
        return userListService.selestUserListByUserId(userId);
    }
    @RequestMapping("/selectUserListByListId")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public List<UserList> selectUserListByListId(String userListId){
        return userListService.selectUserListByListId(userListId);
    }
    @RequestMapping("/addNewUserList")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public List<UserList> addNewUserList(String userListId,String userListName,String userId,String userListImgUrl,String userListSun){
        List<UserList> userList = userListService.selectUserListByListId(userListId);
        int j = Integer.parseInt(userListSun);
        int sun = Integer.parseInt(userListSun);
        if(userList.size() != 0){
            for(int i = 0 ; i < j ; i++){
                sun -= 1;
                userListId = userId + sun;
//                String a = "66666";
//                System.out.println(userListService.selectUserListByListId(a));
                userList = userListService.selectUserListByListId(userListId);
//                System.out.println("循环次数："+ i);
//                System.out.println(userListId);
                if (userList.size() == 0) {
                    userListService.addNewUserSongList(userListId, userListName, userId, userListImgUrl);
                    return userListService.selestUserListByUserId(userId);
                }
            }
        }
        userListService.addNewUserSongList(userListId,userListName,userId,userListImgUrl);
        return userListService.selestUserListByUserId(userId);
    }
    @RequestMapping("/delUserListById")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public List<UserList> delUserListById(String userListId,String userId){
        userListService.delUserListById(userListId);
        return userListService.selestUserListByUserId(userId);
    }
    @RequestMapping("/updateUserListText")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public String updateUserListText(String newUserListText,String userListId){
        userListService.updateUserListText(newUserListText, userListId);

        return "更新成功！";
    }
    @RequestMapping("/updateUserListName")
//    @PreAuthorize("hasRole('user')")
    @ResponseBody
    public String updateUserListName(String newUserListName,String userListId){
//        System.out.println("newUserListName"+newUserListName);
//        System.out.println("userId"+userListId);
        userListService.updateUserListName(newUserListName,userListId);
        return "更新成功！";
    }
}
