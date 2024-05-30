package net.daum.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.daum.vo.BoardVO;

public interface BoardRepository extends JpaRepository<BoardVO, Integer> {

	/* 쿼리메서드란? 메서드 이름만으로 원하는 질의/검색(select) 쿼리문을 만들어 내는 메서드를
	 * 말한다.
	 */
	
	public List<BoardVO> findBoardVOByTitle(String title);
	/* find+엔티티빈클래스명+By+테이블컬럼명 
	 */
	
	public Collection<BoardVO> findByWriter(String name);
	//findBy+엔티티빈 클래스 속성명
	
	public Collection<BoardVO> findByWriterContaining(String name);
	/* findBy와 더불어 가장 많이 사용하는 구문은 검색할 때 사용하는 like구문이다. like문에 대한
	 * 처리는 4가지로 구분된다. 단순한 like, 검색어+'%','%'+검색어,'%'+검색어+'%
	 * 4가지 형태의 검색쿼리 메서드는 다음과 같다.
	 * 형태        검색쿼리 메서드
	 * 단순 like    like
	 * 검색어+'%'     StartingWith
	 * '%'+검색어     EndingWith
	 * '%'+검색어+'%' Containing
	 * 
	 * % 와일드 카드는 SQL문에서 검색할 때 주로 사용한다.의미는 하나이상의 임의의 모르는 문자와 매핑
	 * 대응한다.
	 */
	
	public Collection<BoardVO>
	    findByTitleContainingOrContentContaining(String title,String cont);
	//Or조건처리 => '%'+제목검색어+'%' + Or + '%'+내용검색어+'%'
	
	
	public Collection<BoardVO>
	    findByTitleContainingAndBnoGreaterThan(String title,int bno);
	//title like '%'+제목검색어+'%' And bno > ?
	
	public Collection<BoardVO> findByBnoGreaterThanOrderByBnoDesc(int bno);
	//bno>? order by bno desc =>bno가 특정 번호보다 큰 게시물을 번호를 기준으로 내림차순정렬
	
	@Query("select b from BoardVO b where b.title like %?1% and "
			+" b.bno>0 order by b.bno desc")
	/* JPQL(JPA에서 사용하는 Query Language => Java Persistence Query Language
	 * 의 약어)은 실제 테이블명 대신 엔티티빈 클래스명을 사용하고, 실제 테이블 컬럼명 대신 엔티티빈
	 * 클래스의 속성명을 이용한다. %?1%에서 ?1은 첫번째로 전달되어지는 인자값(parameter
	 * value:피라미터값)을 뜻한다.
	 */
	public List<BoardVO> findByTitle(String title);
	
	@Query("select b from BoardVO b where b.content like "
			+" %:content% and b.bno > 0 order by b.bno desc")
	public List<BoardVO> findByContent(@Param("content") String content);
	//:content는 @Param("content")와 연결된다.
	
	@Query("select b.bno, b.title, b.writer, b.regdate from BoardVO b "
			+" where b.title like %?1% and b.bno>0 order by b.bno desc")
	public List<Object[]> findByTitle2(String title);
	//원하는 컬럼만 추출해서 이용가능 하다. 원하는 컬럼만 지정하는 경우는 리턴 컬렉션 제네릭타입이 해당
	//엔티티 빈 타입이 아니라 Object[] 배열이라는 것에 주의한다.
}
















