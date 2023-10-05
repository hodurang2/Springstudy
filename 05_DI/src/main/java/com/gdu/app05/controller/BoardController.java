package com.gdu.app05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gdu.app05.service.BoardService;

@Controller  // 컨트롤러 전용 @Component
public class BoardController {

  // 주입된 boardService 객체의 변경 방지를 위한 final 처리
  private final BoardService boardService;

  // boardService에 final 처리를 하면 생성자 주입만 가능 (필드와 Setter는 주입 불가능)
  @Autowired  
  public BoardController(BoardService boardService) {
    super();
    this.boardService = boardService;
  }

  @RequestMapping(value="/board/list.do", method=RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("boardList", boardService.getBoardList());
    return "board/list";
  }

  
}