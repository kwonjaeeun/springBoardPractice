package com.koreait.spring.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BoardDomain extends  BoardEntity{
    private String writerNm;
    private String profileImg;
    private int fav;
}
