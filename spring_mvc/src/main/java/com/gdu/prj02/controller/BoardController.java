package com.gdu.prj02.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.prj02.dto.BoardDto;
import com.gdu.prj02.service.BoardService;

@Controller
public class BoardController {
  /*
  @RequestMapping(value="/add.do", method=RequestMethod.GET)
  public String add(HttpServletRequest request) { // 요청 파라미터는 메소드 파라미터로 받는다.
    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
    String title = request.getParameter("title");
    System.out.println(boardNo + ", " + title);
    return "";
  }
  */
  
  /*
  @RequestMapping(value="/add.do", method=RequestMethod.GET)
  public String add(@RequestParam(value="boardNo", required=false, defaultValue="1") int boardNo, @RequestParam(value="title") String title) {
    System.out.println(boardNo + ", " + title);
    return "";
  }
  */
  
  /*
  @RequestMapping(value="/add.do", method=RequestMethod.GET)
  public String add(BoardDto boardDto) {
    System.out.println(boardDto);
    return "";
  }
  */
  
  @RequestMapping(value="/add1.do", method=RequestMethod.GET)
  public String add1(HttpServletRequest request) { // 요청 파라미터는 메소드 파라미터로 받는다.
    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
    String title = request.getParameter("title");
    System.out.println(boardNo + ", " + title);
    return "";
  }
  
  @RequestMapping(value="/add2.do", method=RequestMethod.GET)
  public String add2(@RequestParam(value="boardNo", required=false, defaultValue="1") int boardNo, @RequestParam(value="title") String title) {
    System.out.println(boardNo + ", " + title);
    return "";
  }
  
  @RequestMapping(value="/add3.do", method=RequestMethod.GET)
  public String add3(BoardDto boardDto) {
    System.out.println(boardDto);
    return "";
  }

  
  private BoardService boardService;
  
  @Autowired // @Service로 만드어진 Bean을 매개변수로 가져오세요
  public BoardController(BoardService boardService) {
    super();
    this.boardService = boardService;
  }
  
  

  @RequestMapping(value="/add3.do", method=RequestMethod.GET)
  public String add3(BoardDto boardDto, Model model, RedirectAttributes redirectAttributes) {
    model.addAttribute("result", boardService.add3(boardDto)); // Model은 redirect할 때 값을 전달하지 못한다. 
    return "redirect:/output.do";
  }
  
  @RequestMapping(value="/output.do", method=RequestMethod.GET)
  public String output() {
    return "output";
  }
  
  
}
