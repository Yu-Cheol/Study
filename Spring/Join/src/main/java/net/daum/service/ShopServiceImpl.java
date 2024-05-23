package net.daum.service;

import net.daum.dao.ShopDAO;
import net.daum.vo.ShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDAO shopDAO;

    @Override
    public void insertMember(ShopVO s) {
        this.shopDAO.insertMember(s);
    }
}
