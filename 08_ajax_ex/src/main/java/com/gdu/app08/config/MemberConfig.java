package com.gdu.app08.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app08.dto.MemberDto;

@Configuration
public class MemberConfig {

  @Bean
  public MemberDto member1() {
    return new MemberDto(1, "뽀로로", 180, 90);
  }

  @Bean
  public MemberDto member2() {
    return new MemberDto(2, "루피", 160, 60);
  }

  @Bean
  public MemberDto member3() {
    return new MemberDto(3, "크롱", 171, 730);
  }

  @Bean
  public MemberDto member4() {
    return new MemberDto(4, "포비", 192, 114);
  }

}
