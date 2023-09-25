package com.gdu.app02.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    // app-Ctx.xml 파일 읽기
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml01/appCtx.xml");
    
    // <bean> 태그로 정의된 객체 가져오기
    Person personByProp = (Person)ctx.getBean("person1");
    Person personBycons = ctx.getBean("person2", Person.class);
    
    // 객체 확인
    System.out.println(personByProp.getName() + ", " + personByProp.getAddress() + ", " + personByProp.getContact());
    System.out.println(personBycons.getName() + ", " + personBycons.getAddress() + ", " + personBycons.getContact());
    
    
    // app-Ctx.xml 파일 닫기
    ctx.close();

  }

}
