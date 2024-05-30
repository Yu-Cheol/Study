package net.daum;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.daum.dao.MemberDAO;
import net.daum.vo.MemberVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberDAOTest {

	@Autowired
	private MemberDAO memberDao;
	
	@Test //JUnti test
	public void testInsertMember() {
		MemberVO m=new MemberVO();
		m.setUserid("kkkkk555");
		m.setUserpw("77777");
		m.setUsername("홍길동55");
		m.setEmail("hong55@gmail.com");
		
		this.memberDao.insertMember(m);//회원 저장, this.생략가능
	}
}
