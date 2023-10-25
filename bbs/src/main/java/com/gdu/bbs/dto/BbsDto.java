package com.gdu.bbs.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BbsDto {
  public int bbsNo;
  public String editor;
  public String title;
  public String contents;
  public Date createdAt;
  public Date modifiedAt;
  
}
