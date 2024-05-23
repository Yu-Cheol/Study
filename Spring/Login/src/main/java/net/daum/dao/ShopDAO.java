package net.daum.dao;

import net.daum.vo.ShopVO;

public interface ShopDAO {
    void insertMember(ShopVO s);
    ShopVO loginCheck(String user_id);
}
