package com.koreait.spring.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BoardCmtDomain extends  BoardCmtEntity{
    private String writerNm;
    private String profileImg;
}
