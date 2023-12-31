package com.gdu.lmkWeb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CommentDto {
  private int commentNo;
  private String contents;
  private int userNo;
  private int blogNo;
  private String createdAt;
  private int status;
  private int depth;
  private int groupNo;  
}
