package com.gdu.staff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.staff.dao.StaffMapper;
import com.gdu.staff.dto.StaffDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class StaffUnitTest {

  @Autowired  // Spring Container에서 staffMapper 객체(Bean)를 가져온다.
  private StaffMapper staffMapper;
  
  @Before
  public void 삽입테스트() {
    StaffDto staff = new StaffDto("99999", "김기획", "기획부", 5000);
    int addResult = staffMapper.insertStaff(staff);
    assertEquals(1, addResult);
  }
  
  @Test  // 테스트를 수행한다.
  public void 조회테스트() {
    String sno = "99999";
    StaffDto staff = staffMapper.getStaff(sno);
    assertNotNull(staff);
  }

}