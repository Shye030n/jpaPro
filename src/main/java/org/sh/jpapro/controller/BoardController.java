package org.sh.jpapro.controller;

import lombok.extern.log4j.Log4j2;
import org.sh.jpapro.domain.Board;
import org.sh.jpapro.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {

    @Autowired //보드서비스 주입
    private BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("controller list");
        model.addAttribute("boardList", boardService.getList());
        // getList 함수를 갖고옴
    }
    @GetMapping("/register")
    public void registerGet(){
        log.info("controller registerGet");
    }
    @PostMapping("/register")
    public String registerPost(Board board){
        log.info("controller registerPost");
        boardService.saveBoard(board);
        return "redirect:/board/list";
    }
    @GetMapping("/read")
    public void readGet(){
        log.info("controller readGet");
    }
}
