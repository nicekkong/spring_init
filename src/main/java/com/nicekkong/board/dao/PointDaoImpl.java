/******************************************************
 * Project Name :  board
 * File Name    : .java
 * Author       : nicekkong@gmail.com
 * Create Date  : 2016. 9. 9. 오전 12:00
 * Description  : 
 ******************************************************/
package com.nicekkong.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PointDaoImpl implements PointDao {

    @Autowired
    private SqlSession session;

    private static final String namespace = "com.nicekkong.mapper.PointMapper";

    @Override
    public void updatePoint(String uid, int point) throws Exception {

        Map<String, Object> param = new HashMap<>();
        param.put("uid", uid);
        param.put("point", point);

        session.update(namespace + ".updatePoint", param);
    }
}
