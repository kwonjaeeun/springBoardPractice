package com.koreait.spring.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDomain> selBoardList();
    BoardDomain selBoard(BoardEntity param);
    int writeBoard(BoardEntity param);
    int modBoard(BoardEntity param);
    int delBoard(BoardEntity param);
}
