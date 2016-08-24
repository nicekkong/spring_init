import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/******************************************************
 * Project Name :  spring_board
 * File Name : MybatisTest.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 23. 오후 10:09
 * Description : 
 ******************************************************/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/application-context.xml", "classpath:/mybatis-config.xml"})
public class MybatisTest {
    @Inject
    private SqlSessionFactory sqlSessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
    //Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Test
    public void testFactory() {
        try(SqlSession session  = sqlSessionFactory.openSession()) {
            //logger.info(session);
            System.out.println(session);
            logger.info("test");
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
