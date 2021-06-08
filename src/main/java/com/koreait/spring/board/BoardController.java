package com.koreait.spring.board;

import com.mysql.cj.Session;
import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService service;

    @RequestMapping("list")
    public String list(@RequestParam(value = "searchType",defaultValue ="0")int searchType,
                       @RequestParam(value = "searchText",required = false)String searchText,
                       Model model){
        model.addAttribute("searchType",searchType);
        model.addAttribute("searchText",searchText);
        model.addAttribute("list",service.selBoardlist());
        return "board/list";
    }

    @RequestMapping("detail")
    public String detail(BoardEntity param,Model model){
        model.addAttribute("data",service.selBoard(param));
        return "board/detail";
    }

    @ResponseBody
    @RequestMapping(value = "/cmt",method = RequestMethod.POST)
    public Map<String,Integer> cmtInsSel(@RequestBody BoardCmtEntity param){
        service.InsBoardCmt(param);
        Map<String,Integer> data =new HashMap();
        data.put("result",1);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/cmt/{iboard}")
    public List<BoardCmtDomain> cmtSel(@PathVariable("iboard") int iboard){
        BoardCmtEntity param=new BoardCmtEntity();
        param.setIboard(iboard);
        return service.SelBoardCmtList(param.getIboard());
    }
    @ResponseBody
    @RequestMapping(value = "/cmt/{ict}",method = RequestMethod.DELETE)
    public Map<String,Integer> cmtDel(@PathVariable int ict){
        service.DelBoardCmt(ict);
        Map<String,Integer> data =new HashMap();
        data.put("result",1);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/cmt",method = RequestMethod.PUT)
    public Map<String,Integer> cmtMod(@RequestBody BoardCmtEntity param){
        System.out.println(param);
        service.ModBoardCmt(param);
        Map<String,Integer> data =new HashMap();
        data.put("result",1);
        return data;
    }

}
