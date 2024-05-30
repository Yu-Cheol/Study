package net.daum.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {//JPA로 쿼리문 수행

	@Autowired
	private MemberRepository memberRepo; //JPA 실행할 memberRepo 에 자동의존성 주입

	@Override
	public MemberVO idCheck(String id) {
		System.out.println(" \n 아이디 중복 검색(JPA) =================>");
		Optional<MemberVO> result = this.memberRepo.findById(id);
		MemberVO member;
		if(result.isPresent()) {//중복아이디가 존재하면
			member=result.get();//MemberVO엔티티 타입을 구함.
		}else {
			member=null;//중복아이디가 없다면 null을 저장
		}
		return member;
	}//아이디 중복검색

	@Override
	public void insertMember(MemberVO m) {
	    System.out.println("\n 회원저장(JPA) ======================> ");
	    this.memberRepo.save(m);
	}//회원 저장

	@Override
	public MemberVO pwdMember(MemberVO m) {
		System.out.println("\n 비번 검색(JPA)=======================>");
		MemberVO pm=this.memberRepo.pwdFind(m.getMem_id(), m.getMem_name());
		return pm;
	}//비번검색=>아이디와 회원이름을 기준으로 회원정보를 검색

	@Transactional //javax.persistence.TransactionRequiredException: Executing an update/delete
	//query 에러가 발생하기 때문에 @Transactional을 해줘야 한다.
	@Override
	public void updatePwd(MemberVO m) {
		System.out.println("\n 암호화 된 임시비번으로 수정(JPA)=================>");
		this.memberRepo.updatePwd(m.getMem_pwd(), m.getMem_id());
	}//암호화 된 임시비번으로 수정	
}






