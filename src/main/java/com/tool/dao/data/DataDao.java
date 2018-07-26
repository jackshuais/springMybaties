package com.tool.dao.data;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DataDao {
    List<Map<String,Object>> getDataInfo(@Param("table_name") String table);
}