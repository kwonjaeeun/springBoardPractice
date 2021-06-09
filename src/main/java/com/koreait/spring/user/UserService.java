package com.koreait.spring.user;

import org.apache.commons.io.FilenameUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

    public String uploadProfile(MultipartFile img) {
        UserEntity  loginUser=(UserEntity)session.getAttribute("loginUser");
        final String PATH ="D:/springImg/"+loginUser.getIuser();
        File forder =new File(PATH);
        forder.mkdir();
        String ext = FilenameUtils.getExtension(img.getOriginalFilename());
        String fileNm= UUID.randomUUID().toString()+"."+ext;
        File target=new File(PATH+"/"+fileNm);
        try {
            img.transferTo(target);
            File delFile =new File(PATH+"/"+loginUser.getProfileImg());
            if(delFile.exists()){
                delFile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserEntity param=new UserEntity();
        param.setIuser(loginUser.getIuser());
        param.setProfileImg(fileNm);
        mapper.updUser(param);
        loginUser.setProfileImg(fileNm);
        return"/user/profile";
    }
}
