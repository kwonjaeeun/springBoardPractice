package com.koreait.spring.user;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//주소값과 매핑이 되는 빈등록(servlet과 연결)
@RequestMapping("/user")//class위에 1차주소값
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }
    @RequestMapping("/join")
    public String join(){
        return "user/join";
    }
    @RequestMapping(value ="/join" ,method = RequestMethod.POST)
    public String join(UserEntity param){
        System.out.println("param"+param);
        return "redirect:/user/login";
    }
}
