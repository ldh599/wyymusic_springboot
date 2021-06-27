package com.ldhmusic.music.auth;

import com.alibaba.fastjson.JSON;
import com.ldhmusic.music.entity.AjaxResponseBodyUserInfo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        AjaxResponseBodyUserInfo ajaxResponseBodyUserInfo = new AjaxResponseBodyUserInfo();
//防止中文乱码
        httpServletResponse.setContentType("text/json;charset=utf-8");

        ajaxResponseBodyUserInfo.setStatus("000");
        ajaxResponseBodyUserInfo.setMsg("未登录");
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Method","POST,GET");
        httpServletResponse.getWriter().write(JSON.toJSONString(ajaxResponseBodyUserInfo));
    }
}
