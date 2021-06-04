package com.koreait.spring.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private HttpSession session;

    public String login(UserEntity param){
        UserEntity result=mapper.selUser(param);
        String go="redirect:";
        if(result==null){
            go+="/user/login?err=1";
        }else if(BCrypt.checkpw(param.getUpw(),result.getUpw())){
            result.setUpw(null);
            session.setAttribute("loginUser",result);
            go+="/board/list";
        }else{
            go+="/user/login?err=2";
        }
        return go;
    }

    public int join(UserEntity param){
        String cpw = BCrypt.hashpw(param.getUpw(),BCrypt.gensalt());
        param.setUpw(cpw);
        return mapper.insUser(param);
    }
}
