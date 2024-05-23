package net.daum.service;

import net.daum.vo.ShopVO;

public interface ShopService {
    void insertMember(ShopVO s);
    ShopVO loginCheck(String user_id);
}
