package net.daum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.daum.dao.MemberRepository;
import net.daum.dao.ProfileRepository;
import net.daum.vo.MemberVO;
import net.daum.vo.Profile;

@SpringBootTest
class Boot04ApplicationTests {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private ProfileRepository profileRepo;
	
	@Test
	void contextLoads() {
	}

	//20명 회원 샘플 더미 데이터 저장
	@Test
	public void testMemberInsert() {
       IntStream.range(1,21).forEach(i->{//1부터 20까지 숫자 생성
    	   
    	   MemberVO m=new MemberVO();
    	   
    	   m.setUid2("user"+ i);
    	   m.setUpw("pw"+ i);
    	   m.setUname("사용자"+i);
    	   
    	   //this.memberRepo.save(m);//20명 회원 저장
       });		
	}//testMemberInsert()
	
	//특정회원에 프로필 사진 추가
    @Test
    public void testInsertProfile(){
    	
    	MemberVO member=new MemberVO();
    	member.setUid2("user1");
    	
    	for(int i=1;i<=4;i++) {
    		Profile profile01=new Profile();
    		profile01.setFname("face"+i+".jpg");
    		
    		if(i==1) {
    			profile01.setCurrent2(true);//face1.jpg가 현재 사용중인 프로필사진
    		}
    		
    		profile01.setMember(member);
    		
    		//this.profileRepo.save(profile01);
    	}//for
    }//testInsertProfile()	
    
    //user1 회원아이디 정보와 프로필 사진개수 =>페치 조인(Fetch Join)=>연관 관계
    @Test
    public void testFetchJoin01() {
    	//List<Object[]> result=
    		//	this.memberRepo.getMemberVOWithProfileCount("user1");
    	
    	//result.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }//testFetchJoin01()
    
    //user1 아이디 회원정보와 현재 사용중인 프로필 사진 정보
    @Test
    public void testFetchJoin02() { //단방향 Fetch Join
    	List<Object[]> result=
    			this.memberRepo.getMemberVOWithProfile("user1");
    	
    	result.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }//testFetchJoin02()
}























