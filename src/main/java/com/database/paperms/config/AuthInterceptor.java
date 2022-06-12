package com.database.paperms.config;

import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String userAccount = (String) session.getAttribute("user_account");
        if (userAccount == null) {
            response.setCharacterEncoding("UTF8");
            response.setContentType("application/json");
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.print(new ObjectMapper().writeValueAsString(new ResultData<>(ReturnCode.ACCESS_DENIED)));
            outputStream.flush();
            return false;
        }
        return true;
    }


}
