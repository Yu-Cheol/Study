package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.daum.dao.MessageDAO;
import net.daum.dao.PointDAO;
import net.daum.vo.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {
/* 하나의 SeviceImpl에서 두개의 DAO로 나눠진다는 것에 유의 
 */
	@Autowired
	private MessageDAO messageDao;
	
	@Autowired
	private PointDAO pointDao;

	//스프링 AOP를 통한 트랜잭션 적용부분
	@Transactional //트랜잭션 적용
	@Override
	public void addM(MessageVO vo) {
       this.messageDao.addM(vo);//메시지 추가
       this.pointDao.updatePoint(vo.getSender(),10);//메시지를 보낸사람에게 포인트
       //점수 10점 업=>즉 메시지 추가 하나당 포인트 점수 10점 업데이트
	}		
}







