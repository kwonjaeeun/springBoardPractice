package com.koreait.spring.board;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardCmtEntity {
    private int ict;
    private int iboard;
    private int iuser;
    private String ctnt;
    private String regdt;

}
