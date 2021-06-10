package com.koreait.spring.board;

import com.koreait.spring.MyUtils;
import com.koreait.spring.user.UserEntity;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class BoardFavService {
    @Autowired
    private BoardFavMapper mapper;
    @Autowired
    private MyUtils utils;
    public int insFav(BoardFavEntity param){
        param.setIuser(utils.getUserIuser());
        return mapper.insBoardFav(param);
    }
    public int selFav(BoardFavEntity param){
        param.setIuser(utils.getUserIuser());
        return mapper.selBoardFav(param);
    }
    public int delFav(BoardFavEntity param){
        param.setIuser(utils.getUserIuser());
        return mapper.delBoardFav(param);
    }
}
