package com.gdu.myapp;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.myapp.dao.NoticeDao;
import com.gdu.myapp.dto.NoticeDto;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class ContactUnitTest {


	  @Autowired  // Spring Container에서 ContactDao 객체(Bean)를 가져온다.
	  private NoticeDao noticeDao;
	  
	  @Test  // 테스트를 수행한다.
	  public void test01_삽입테스트() {
	    NoticeDto noticeDao = new NoticeDto(0, "구분", "제목", "내용");
	    int insertResult = noticeDao.insert(noticeDao);
	    assertEquals(1, insertResult);  // insertResult가 1이면 테스트 성공이다.
	  }
	  
	  @Test  // 테스트를 수행한다.
	  public void test02_조회테스트() {
	    int notice_no = 1;
	    NoticeDto noticeDto = noticeDao.selectNoticeByNo(notice_no);
	    assertNotNull(noticeDto);  // contactDto가 not null이면 테스트 성공이다.
	  }
	  
	  @Test  // 테스트를 수행한다.
	  public void test03_삭제테스트() {
	    int notice_no = 1;
	    int deleteResult = noticeDao.delete(notice_no);
	    assertEquals(1, deleteResult);  // deleteResult가 1이면 테스트 성공이다.
	    // assertNull(contactDao.selectContactByNo(contact_no));  select 결과가 null이면 테스트 성공이다.
	  }

}
