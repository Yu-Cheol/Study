package net.daum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import net.daum.dao.BoardDAO;
import net.daum.vo.BoardVO;

@Service //@Service 애노테이션을 추가함으로써 스프링에서 서비스로 인식하게 한다.
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;

	@Override
	public void insertBoard(BoardVO b) {
		this.boardDao.insertBoard(b);		
	}

	@Override
	public int getTotalCount() {
		return this.boardDao.getTotalCount();
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return boardDao.getBoardList(b);
	}

	/* 스프링 AOP를 통한 트랜잭션 적용대상 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	//트랜잭션 격리(트랜잭션이 처리되는 중간에 외부간섭을 배제한다. READ_COMMITTED 옵션은
	//커밋된 데이터에 대해 읽기 허용)
	@Override
	public BoardVO getBoardCont(int bno) {
		this.boardDao.updateHit(bno);//조회수 증가
		return this.boardDao.getBoardCont(bno);//번호에 해당하는 레코드 가져오기
	}

	@Override
	public BoardVO getBoardCont2(int bno) {
		return this.boardDao.getBoardCont(bno);
	}

	@Override
	public void editBoard(BoardVO eb) {
		this.boardDao.editBoard(eb);		
	}

	@Override
	public void delBoard(int bno) {
		this.boardDao.delBoard(bno);
	}	
}
