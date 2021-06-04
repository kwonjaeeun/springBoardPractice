package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    @RequestMapping(value = "/cmtInsSel",method = RequestMethod.POST)
    public Map<String,Integer> cmtInsSel(@RequestBody BoardCmtEntity param){
        Map<String,Integer> result =new HashMap();
        System.out.println("param:"+param);
        result.put("result",1);
        result.put("age",11);
        return result;
    }

}
