package com.gdu.lmkWeb.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FreeDto {
  private int freeNo;
  private String email;
  private String contents;
  private Date createdAt;
  private int status;
  private int depth;
  private int groupNo;
  private int groupOrder;
}
