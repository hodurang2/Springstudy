package com.gdu.app08.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app08.dto.MemberDto;

@Repository
public class MemberDao {
  private MemberDto member1;
  private MemberDto member2;
  private MemberDto member3;
  private MemberDto member4;

  @Autowired
  public void setBean(MemberDto member1, MemberDto member2, MemberDto member3, MemberDto member4) {
    this.member1 = member1;
    this.member2 = member2;
    this.member3 = member3;
    this.member4 = member4;
  }

  public MemberDto getMemberByNo(int memberNo) {
    MemberDto member = null;

    if (memberNo == member1.getMemberNo()) {
      member = member1;
    } else if (memberNo == member2.getMemberNo()) {
      member = member2;
    } else if (memberNo == member3.getMemberNo()) {
      member = member3;
    } else if (memberNo == member4.getMemberNo()) {
      member = member4;
    }

    return member;
  }

}
