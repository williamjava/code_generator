package com.code.dao;

import java.util.List;
import java.util.Map;

/**
 * 数据库接口
 *
 * @author william
 * @email wuhoujian@126.com
 * @date 2019/1/11
 */
public interface GeneratorDao {
    List<Map<String, Object>> queryList(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
