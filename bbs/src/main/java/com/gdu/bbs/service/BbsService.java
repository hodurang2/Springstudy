package com.gdu.bbs.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BbsService {
  // request를쓰는이유 : getParameter(), getContextPath()를 사용하기 위해
  // parameter를쓰는이유 : parameter말고는 필요한 정보가 없으므로 쓸필요 X
  // 2개이상 저장할때는 return 설정보단 Model에 따로 저장
  public void loadBbsList(HttpServletRequest request, Model model);
 
}
