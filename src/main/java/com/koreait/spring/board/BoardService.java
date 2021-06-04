package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private  BoardMapper mapper;

    public  List<BoardDomain> selBoardlist(){
       return mapper.selBoardList();
    }

    public BoardDomain selBoard(BoardEntity param) {
        return mapper.selBoard(param);
    }
}
