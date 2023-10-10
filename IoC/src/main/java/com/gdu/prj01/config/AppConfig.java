package com.gdu.prj01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.prj01.dto.BoardDto;
import com.gdu.prj01.dto.UserDto;

@Configuration // 이 클래스는 Bean을 만드는 클래스입니다.
public class AppConfig {
  
  @Bean // 이 메소드는 Bean입니다.
  public UserDto user3() {  // 메소드이름 user3이 Bean의 id입니다.
    UserDto user = new UserDto();
    user.setUserNo(3);
    user.setUserId("myId");
    return user;
  }
  
  @Bean
  public BoardDto board3() {
    BoardDto board = new BoardDto();
    board.setBoardNo(3);
    board.setTitle("안녕하세요");
    board.setUserDto(user3());
    return board;
  }
  
  
}
