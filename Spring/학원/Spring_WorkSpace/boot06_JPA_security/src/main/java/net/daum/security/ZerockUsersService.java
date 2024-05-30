package net.daum.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import net.daum.dao.MemberRepository;

@Service //스프링에서 빈으로 처리
@Log
public class ZerockUsersService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		System.out.println(" \n ================> UserDetailsService로 접근");
		
		return 
				this.memberRepo.findById(username)
				.filter(member -> member != null) //검색된 회원정보가 있다면
				.map(member -> new ZerockSecurityUser(member, request)).get();
		        //검색된 회원정보를 ZerockSecurityUser 생성자 인자값으로 전달하고 get()메서드로 
		        //ZerockSecurityUser 객체타입을 구함
	}

}
