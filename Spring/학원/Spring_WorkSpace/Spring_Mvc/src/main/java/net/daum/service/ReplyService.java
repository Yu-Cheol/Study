package net.daum.service;

import java.util.List;

import net.daum.vo.ReplyVO;

public interface ReplyService {

	void insertReply(ReplyVO vo);
	List<ReplyVO> replyList(int bno);
	void editReply(ReplyVO vo);
	void deleteReply(int rno);

}
