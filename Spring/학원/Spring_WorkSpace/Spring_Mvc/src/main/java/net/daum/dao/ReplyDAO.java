package net.daum.dao;

import java.util.List;

import net.daum.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(ReplyVO vo);
	List<ReplyVO> replyList(int bno);
	void editReply(ReplyVO vo);
	void deleteReply(int rno);
	int getBno(int rno);

}
