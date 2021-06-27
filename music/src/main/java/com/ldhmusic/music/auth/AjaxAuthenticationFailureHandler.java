package com.ldhmusic.music.auth;

import com.alibaba.fastjson.JSON;
import com.ldhmusic.music.entity.AjaxResponseBodyUserInfo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller

public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        AjaxResponseBodyUserInfo ajaxResponseBodyUserInfo = new AjaxResponseBodyUserInfo();
//防止中文乱码
        httpServletResponse.setContentType("text/json;charset=utf-8");
        ajaxResponseBodyUserInfo.setStatus("300");
        ajaxResponseBodyUserInfo.setMsg("登录失败");
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Method","POST,GET");

        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResponseBodyUserInfo));
    }
}
