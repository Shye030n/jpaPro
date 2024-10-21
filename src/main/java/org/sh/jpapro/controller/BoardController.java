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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    //read.html과 modify.html은 비슷해서..?
    @GetMapping({"/read", "/modify"})
    public void read(Long bno, Model model){
        log.info("controller read"+bno);
        model.addAttribute("dto", boardService.getBoard(bno));
    }
    @PostMapping("/modify")
    public String modify(Board board, RedirectAttributes redirectAttributes){
        log.info("controller modify"+board);
        boardService.updateBoard(board);
        redirectAttributes.addAttribute("bno", board.getBno());
        return "redirect:/board/read";
    }
    @PostMapping("/remove")
    public String remove(Board board){
        log.info("controller remove"+board);
        boardService.deleteBoard(board.getBno());
        return "redirect:/board/list";
    }
}
