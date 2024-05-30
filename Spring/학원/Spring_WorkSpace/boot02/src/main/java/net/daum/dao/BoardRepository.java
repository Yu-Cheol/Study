package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.daum.vo.BoardVO;

public interface BoardRepository extends JpaRepository<BoardVO, Integer> {
	/* <엔티티빈 클래스 제네릭 타입,  @Id 기본키 컬럼 제네릭 타입>으로 설정함. 제네릭 타입은 
	 * 기본타입은 안되고 참조타입만 가능하기 때문에 기본 정수 int 타입의 래퍼 참조타입인 Integer
	 * 로 설정함.
	 * 
	 * JpaRepository 인터페이스의 부모 인터페이스는 PagingAndSortingRepository이다.
	 * 이 인터페이스의 역할은 페이징과 정렬이라는 기능을 제공한다.
	 * 이 인터페이스의 부모 인터페이스는 CrudRepository이다.
	 * CrudRepository의 부모 인터페이스는 Repository 이다.
	 */

}
