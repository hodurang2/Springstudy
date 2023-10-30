package com.gdu.lmkWeb.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.lmkWeb.dto.InactiveUserDto;
import com.gdu.lmkWeb.dto.LeaveUserDto;
import com.gdu.lmkWeb.dto.UserDto;

@Mapper
public interface UserMapper {
  public UserDto getUser(Map<String, Object> map);
  public int insertAccess(String email);
  public LeaveUserDto getLeaveUser(Map<String, Object> map);
  public InactiveUserDto getInactiveUser(Map<String, Object> map);
  public int insertUser(UserDto user);
  public int updateUser(UserDto user);
  public int updateUserPw(UserDto user);
  public int insertLeaveUser(UserDto user);
  public int deleteUser(UserDto user);
  public void insertInactiveUser();
  public void deleteUserForInactive();
  public int insertActiveUser(String email);
  public int deleteInactiveUser(String email);
  public int insertNaverUser(UserDto user);
  
}