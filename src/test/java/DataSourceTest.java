import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;

/******************************************************
 * Project Name :  spring_board
 * File Name : DataSourceTest.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 23. 오전 1:10
 * Description : 
 ******************************************************/


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath:/application-context.xml"}
)
public class DataSourceTest {

    @Inject
    private DataSource ds;

    @Test
    public void testConnection() throws Exception {
        try(Connection conn = ds.getConnection()){
            System.out.println(conn);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
