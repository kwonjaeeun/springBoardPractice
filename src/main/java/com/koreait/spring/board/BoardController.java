package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
