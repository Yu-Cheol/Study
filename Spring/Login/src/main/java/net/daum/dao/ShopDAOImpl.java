package net.daum.dao;

import net.daum.vo.ShopVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDAOImpl implements ShopDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void insertMember(ShopVO s) {
        this.sqlSession.insert("join", s);
    }

    @Override
    public ShopVO loginCheck(String user_id) {
        return this.sqlSession.selectOne("login", user_id);
    }

}
