/******************************************************
 * Project Name :  spring_board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 29. 오전 12:05
 * Description : 
 ******************************************************/

package com.nicekkong.board.dao;

import com.nicekkong.board.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Inject
    private SqlSession sqlSession;

    private static final String namespace = "com.nicekkong.mapper.member.Mapper";

    @Override
    public String getTime() {
        return sqlSession.selectOne(namespace + ".getTime");
    }

    @Override
    public void intertMember(Member member) {
        sqlSession.insert(namespace + ".insertMember", member);
    }

    @Override
    public Member readMember(String memberId) throws Exception {

        return sqlSession.selectOne(namespace+".selectMember", memberId);
    }

    @Override
    public Member readWithPw(String userId, String userPw) throws Exception {

        Map<String, Object> paramMap = new HashMap<String, Object>();

        paramMap.put("userId", userId);
        paramMap.put("userPw", userPw);

        return sqlSession.selectOne(namespace + ".readPw", paramMap);
    }
}
