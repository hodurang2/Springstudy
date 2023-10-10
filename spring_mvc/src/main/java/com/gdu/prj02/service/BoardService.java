package com.gdu.prj02.service;

import javax.servlet.http.HttpServletRequest;

import com.gdu.prj02.dto.BoardDto;

public interface BoardService {
  
  public void add1(HttpServletRequest request);     
  public void add2();     
  public void add3(BoardDto boardDto);     
  
  
}
