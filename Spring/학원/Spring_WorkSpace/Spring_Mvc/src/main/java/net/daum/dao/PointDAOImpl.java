package net.daum.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {//PointDAOImpl에서 point.xml
	//를 통한 tbl_user테이블에  메시지를 보낸 사람에게 포인트 점수 10점 업데이트

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void updatePoint(String sender, int point) {
		Map<String,Object> pm=new HashMap<>();
		
		pm.put("sender", sender);//sender키이름에 메시지를 보낸사람을 저장
		pm.put("point", point);
		
		this.sqlSession.update("pointUp", pm);
	}//메시지를 보낸사람에게 포인트 점수 10점 업
	/* DAOImpl에서 mybatis 해당 매퍼xml태그로 복수개의 인자값을 전달할 경우에는 관례적으로
	 * java.util패키지의 컬렉션인 키,값 쌍구조로 저장되는 영어사전적인 자료구조인 Map을 사용한다.
	 */
}
