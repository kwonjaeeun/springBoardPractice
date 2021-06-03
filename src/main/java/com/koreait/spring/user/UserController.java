package com.koreait.spring.user;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//주소값과 매핑이 되는 빈등록(servlet과 연결)
@RequestMapping("/user")//class위에 1차주소값
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "err",defaultValue = "0") int err, Model model){
        switch (err){
            case 1:
                model.addAttribute("errmsg","아이디 잘못됨") ;
                break;
            case 2:
                model.addAttribute("errmsg","비밀번호가 잘못됨") ;
                break;
        }
        return "user/login";
    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(UserEntity param)
    {
        return service.login(param);
    }
    @RequestMapping("/join")
    public String join(){
        return "user/join";
    }
    @RequestMapping(value ="/join" ,method = RequestMethod.POST)
    public String join(UserEntity param){
        service.join(param);
        System.out.println("param"+param);

        return "redirect:/user/login";
    }
}
