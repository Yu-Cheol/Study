package net.daum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.daum.dao.BoardDAO;
import net.daum.dao.ReplyDAO;
import net.daum.vo.ReplyVO;

@Service //@Service 애노테이션을 설정해야 스프링에서 서비스로 인식한다.
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDao;
	
	@Autowired
	private BoardDAO boardDao;

	@Transactional //스프링의 aop를 통한 트랜잭션 처리 => 데이터 일관성 유지
	@Override
	public void insertReply(ReplyVO vo) {
		this.replyDao.insertReply(vo);//댓글이 추가		
		this.boardDao.updateReplyCnt(vo.getBno(),1);//새로운 댓글이 추가되면
		//replycnt컬럼에  댓글 개수 1 증가
	}//댓글이 추가되면 댓글수 1증가

	@Override
	public List<ReplyVO> replyList(int bno) {
		return this.replyDao.replyList(bno);
	}

	@Override
	public void editReply(ReplyVO vo) {
		this.replyDao.editReply(vo);		
	}

	@Transactional //스프링의 aop를 통한 트랜잭션 적용대상
	@Override
	public void deleteReply(int rno) {
		int bno = this.replyDao.getBno(rno);//댓글이 삭제되기 전에 먼저 게시판 번호값을
		//구해야 한다.
		this.replyDao.deleteReply(rno);//댓글 삭제		
		this.boardDao.updateReplyCnt(bno, -1);//댓글이 삭제되면 댓글 개수 1감소
	}//댓글이 삭제되면 댓글수 1감소	
}


