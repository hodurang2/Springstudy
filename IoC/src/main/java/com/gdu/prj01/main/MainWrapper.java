package com.gdu.prj01.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.gdu.prj01.config.AppConfig;
import com.gdu.prj01.dto.BoardDto;

public class MainWrapper {

  public static void main(String[] args) {
    
    AbstractApplicationContext ctx1 = new GenericXmlApplicationContext("com/gdu/prj01/app-context");
    BoardDto boardDto1 = ctx1.getBean("board1", BoardDto.class);
    System.out.println(boardDto1);
    BoardDto boardDto2 = (BoardDto)ctx1.getBean("board2");
    System.out.println(boardDto2);
    ctx1.close();
    
    AbstractApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppConfig.class);
    BoardDto boardDto3 = ctx2.getBean("board3", BoardDto.class);
    System.out.println(boardDto3);
    ctx2.close();
    
    
    
    
    
    
    
    
  }

}
