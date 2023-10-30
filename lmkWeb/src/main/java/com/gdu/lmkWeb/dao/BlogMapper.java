package com.gdu.lmkWeb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.lmkWeb.dto.BlogDto;
import com.gdu.lmkWeb.dto.BlogImageDto;

@Mapper
public interface BlogMapper {
  public int insertBlog(BlogDto blog);
  public int insertBlogImage(BlogImageDto blogImage);
  public List<BlogImageDto> getBlogImageInYesterday();
}