import com.nicekkong.board.domain.Member;
import com.nicekkong.board.dao.MemberDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/******************************************************
 * Project Name :  spring_board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 29. 오전 12:11
 * Description : 
 ******************************************************/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/application-context.xml", "classpath:/mybatis-config.xml"})
public class MemberDaoTest {

    @Inject
    private MemberDao dao;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testTime() throws Exception {

        logger.info(dao.getTime());
    }

    @Test
    public void testInsertMember() throws Exception {

        Member member = new Member();
        member.setEmail("nicekkong@gmail.com");
        member.setUserId("닉구아르");
        member.setUserName("Nic kuaru");
        member.setUserPw("1q2w3e4r5t");

        dao.intertMember(member);
    }

    @Test
    public void testSelectWithPw() throws Exception {

        Member member = dao.readWithPw("0003", "0003");
        member.getEmail();
        logger.info(member.toString() + "//////" + member.getEmail());
    }
}
