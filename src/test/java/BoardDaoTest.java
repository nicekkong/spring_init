/******************************************************
 * Project Name :  board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 30. 오전 6:11
 * Description :
 ******************************************************/

import com.nicekkong.board.dao.BoardDao;
import com.nicekkong.board.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/application-context.xml",
                                            "classpath:/mybatis-config.xml"})
public class BoardDaoTest {

    @Inject
    private BoardDao boardDao;

    @Test
    public void testCreate() throws Exception {
        Board board = new Board();
        board.setTitle("새로운 글입니다 20160830");
        board.setContent("새로운 글 새로운 내용 ");
        board.setWriter("nicekkong@gmail.com");

        boardDao.create(board);
    }
}
