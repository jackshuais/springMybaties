package com.tool.service;

import com.tool.dao.data.DataDao;
import com.tool.dao.game.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/7/26.
 */
@Service
public class TestService {
    private final static Logger logger= LoggerFactory.getLogger(TestService.class);

    @Autowired
    private BaseDao dao;

    @Autowired
    private DataDao dataDao;

    public void getTrump(){
        List<Map<String,Object>> list = dao.getTrump();
        System.out.println(list.toString());
    }
    public void getTableInfo(String table){
        logger.info("1111111");
        List<Map<String,Object>> list = dataDao.getDataInfo(table);
        for (Map<String,Object> map:list) {
            System.out.println(map.toString());
        }
    }
}
