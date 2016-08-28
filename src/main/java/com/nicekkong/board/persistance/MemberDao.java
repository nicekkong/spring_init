/******************************************************
 * Project Name :  spring_board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 28. 오전 1:23
 * Description : 
 ******************************************************/

package com.nicekkong.board.persistance;

import com.nicekkong.board.domain.Member;

public interface MemberDao {

    public String getTime();

    public void intertMember(Member member);

    public Member readMember(String memberId) throws Exception;

    public Member readWithPw(String userId, String userPw) throws Exception;

}
