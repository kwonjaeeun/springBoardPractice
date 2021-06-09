package com.koreait.spring.board;

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
    HttpSession session;

    public  List<BoardDomain> selBoardlist(){
       return mapper.selBoardList();
    }

    public BoardDomain selBoard(BoardEntity param) {
        return mapper.selBoard(param);
    }

    public int writeMod(BoardEntity param) {
        UserEntity user =(UserEntity) session.getAttribute("loginUser");
        param.setIuser(user.getIuser());
        if(param.getIboard()==0){
            return    mapper.writeBoard(param);
        }
        return  mapper.modBoard(param);
    }

    public int InsBoardCmt(BoardCmtEntity param){
        UserEntity user =(UserEntity) session.getAttribute("loginUser");
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
        UserEntity user =(UserEntity) session.getAttribute("loginUser");
        param.setIuser(user.getIuser());
        return CmtMapper.delBoardCmt(param);
    }

    public int ModBoardCmt(BoardCmtEntity param) {
        UserEntity user =(UserEntity) session.getAttribute("loginUser");
        param.setIuser(user.getIuser());
        return CmtMapper.modBoardCmt(param);
    }

}
