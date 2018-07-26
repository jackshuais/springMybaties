package com.tool.dao.game;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BaseDao {
    List<Map<String,Object>> getTrump();
}