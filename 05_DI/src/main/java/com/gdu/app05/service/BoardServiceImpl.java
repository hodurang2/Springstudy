package com.gdu.app05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app05.dao.BoardDao;
import com.gdu.app05.dto.BoardDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service // 서비스 계층(Business Layer) 전용 @Component, Spring Container에 BoardService boardServiceImpl 객체를 생성해 둔다.
public class BoardServiceImpl implements BoardService {

  // 주인된 boardDao 객체의 변경 방지를 위해 final 처리
  private final BoardDao boardDao;

  @Override
  public List<BoardDto> getBoardList() {
    return boardDao.getBoardList();
  }

}