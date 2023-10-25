package com.gdu.myhome.intercept;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * LoginStatusCheckInterceptor
 * 이미 로그인이 되어있을 때 인터셉터
 */
@Component
public class RequiredLoginInterceptor implements HandlerInterceptor {
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    
    HttpSession session = request.getSession();
    
    if(session != null && session.getAttribute("user") != null) {
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<script>");
      out.println("alert('이미 로그인 상태입니다')");
      out.println("history.back()");
      out.println("</script>");
      out.flush();
      out.close();
      
      return false; // 가로챈 컨트롤러 요청이 더 이상 동작하지 않는다.
      
    }
    
    return true;    // 가로챈 컨트롤러 요청이 동작한다.
  }
  
}
