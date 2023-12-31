package com.gdu.myhome.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myhome.dto.BlogDto;
import com.gdu.myhome.service.BlogService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/blog")
@RequiredArgsConstructor
@Controller
public class BlogController {

  private final BlogService blogService;
  
  @GetMapping("/list.do")
  public String list(HttpServletRequest request, Model model) {
    blogService.loadBlogList(request, model);
    return "blog/list";
  }
  
  @GetMapping("/write.form")
  public String write() {
    return "blog/write";
  }
  
  @ResponseBody
  @PostMapping(value="/imageUpload.do", produces="application/json")
  public Map<String, Object> imageUpload(MultipartHttpServletRequest multipartRequest) {
    return blogService.imageUpload(multipartRequest);
  }
  
  @PostMapping("/addBlog.do")
  public String addBlog(HttpServletRequest request, RedirectAttributes redirectAttributes) {
    int addResult = blogService.addBlog(request);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/blog/list.do";
  }
  
  @GetMapping("/increaseHit.do")
  public String increaseHit(@RequestParam(value="blogNo", required=false, defaultValue="0") int blogNo) {
    int increaseResult = blogService.increaseHit(blogNo);
    if(increaseResult == 1) {
      return "redirect:/blog/detail.do?blogNo=" + blogNo;
    } else {
      return "redirect:/blog/list.do";
    }
  }
  
  @GetMapping("/detail.do")
  public String detail(@RequestParam(value="blogNo", required=false, defaultValue="0") int blogNo
                     , Model model) {
    BlogDto blog = blogService.getBlog(blogNo);
    model.addAttribute("blog", blog);
    return "blog/detail";
  }
  
  @ResponseBody
  @PostMapping(value="/addComment.do", produces="application/json")
  public Map<String, Object> addComment(HttpServletRequest request){
    return blogService.addComment(request);
  }
  
  @ResponseBody
  @GetMapping(value="/commentList.do", produces="application/json" )
  public Map<String, Object> commentList(HttpServletRequest request) {
    return blogService.loadCommentList(request);
  }
  
  
}