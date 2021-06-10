package com.koreait.spring.board;

import com.koreait.spring.MyUtils;
import com.koreait.spring.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private  BoardMapper mapper;
    @Autowired
    private BoardCmtMapper CmtMapper;
    @Autowired
    private MyUtils utils;

    public  List<BoardDomain> selBoardlist(){
       return mapper.selBoardList();
    }

    public BoardDomain selBoard(BoardEntity param) {
        return mapper.selBoard(param);
    }

    public int writeMod(BoardEntity param) {
        UserEntity user =utils.getUser();
        param.setIuser(user.getIuser());
        if(param.getIboard()==0){
            mapper.writeBoard(param);
        }else{
            mapper.modBoard(param);
        }
        return param.getIboard();
    }

    public int InsBoardCmt(BoardCmtEntity param){
        UserEntity user =utils.getUser();
        param.setIuser(user.getIuser());
        System.out.println("111");
        return CmtMapper.insBoardCmt(param);
    }

    public List<BoardCmtDomain> SelBoardCmtList(int iboard) {
        return CmtMapper.selBoardCmtList(iboard);
    }

    public int DelBoardCmt(int ict) {
        BoardCmtEntity param= new BoardCmtEntity();
        param.setIct(ict);
        param.setIuser(utils.getUserIuser());
        return CmtMapper.delBoardCmt(param);
    }

    public int ModBoardCmt(BoardCmtEntity param) {
        param.setIuser(utils.getUserIuser());
        return CmtMapper.modBoardCmt(param);
    }

    public int delBoard(int iboard) {
        BoardEntity param=new BoardEntity();
        param.setIboard(iboard);
        param.setIuser(utils.getUserIuser());
        return mapper.delBoard(param);
    }
}
