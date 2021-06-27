package com.ldhmusic.music.auth;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ldhmusic.music.entity.AjaxResponseBodyUserInfo;
import com.ldhmusic.music.entity.UserInfo;
import com.ldhmusic.music.response.Result;
import com.ldhmusic.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import springfox.documentation.spring.web.json.Json;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class AjaxAuthentionSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication)
            throws IOException, ServletException {
//已json格式返回
//        Result result = Result.ok();
        //防止中文乱码
        httpServletResponse.setContentType("text/json;charset=utf-8");
//        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(result));
//
        AjaxResponseBodyUserInfo ajaxResponseBodyUserInfo = new AjaxResponseBodyUserInfo();
        UserInfo result = new UserInfo();
        UserInfo userInfo = userService.selectUserByID(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName());

        result.setUserId(userInfo.getUserId());
        result.setUserName(userInfo.getUserName());
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());

        ajaxResponseBodyUserInfo.setStatus("200");
        ajaxResponseBodyUserInfo.setMsg("登陆成功！");
        ajaxResponseBodyUserInfo.setResult(result);

        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Method","POST,GET");

        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResponseBodyUserInfo));
    }
}
