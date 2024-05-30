package net.daum.dao;

import net.daum.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO m);
	/* 인터페이스에 오는 추상메서드 특징)
	 *  1.public abstract 이 생략될 수 있다.
	 *  2.{}가 없고,실행문장이 없어서 호출 불가능 하다.
	 *  3.인터페이스를 구현상속한 자손클래스에서 반드시 부모 인터페이스의 추상메서드를 오버라이딩을
	 *  해야 한다.
	 */

}
