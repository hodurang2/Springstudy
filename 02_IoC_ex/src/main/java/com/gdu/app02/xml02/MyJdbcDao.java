package com.gdu.app02.xml02;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyJdbcDao {
  
  
  private Connection con;
  
  public Connection getConnection() {
    // 반환값 : MyJdbcConnection 클래스의 getConnection() 메소드 호출
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml02/appCtx.xml");
    MyJdbcConnection myJdbcConnection = ctx.getBean("myJdbcConnection", MyJdbcConnection.class);
    ctx.close();
    return myJdbcConnection.getConnection();
  }

  private void close() {
    try {
      if(con != null)
        con.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  public void add() {
    con = getConnection();
    System.out.println("add() 호출");
    close();
  }
  
  public void remove() {
    con = getConnection();
    System.out.println("remove() 호출");
    close();
  }
  
  public void modify() {
    System.out.println("modify() 호출");
    con = getConnection();
    close();
  }
  
  public void select() {
    con = getConnection();
    System.out.println("select() 호출");
    close();
    
  }
  
  
}
