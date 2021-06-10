package com.koreait.spring;

import com.koreait.spring.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class MyUtils {

    @Autowired
    private HttpSession session;

    public UserEntity getUser(){
        return (UserEntity) session.getAttribute("loginUser");
    }
    public int getUserIuser(){
       return getUser().getIuser();
    }
}
