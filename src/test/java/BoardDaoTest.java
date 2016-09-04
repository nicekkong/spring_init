/******************************************************
 * Project Name :  board
 * File Name : .java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 30. 오전 6:11
 * Description :
 ******************************************************/

import com.nicekkong.board.dao.BoardDao;
import com.nicekkong.board.domain.Board;
import com.nicekkong.board.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/application-context.xml",
                                            "classpath:/mybatis-config.xml"})
public class BoardDaoTest {

    private final static Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);


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

    @Test
    public void testListPage() throws Exception {
        int page=3;
        List<Board> boardList = boardDao.listPage(page);

        for(Board board : boardList) {
            logger.info(board.getBno() + " //// " + board.getTitle());
        }
    }

    @Test
    public void testListCriteria() throws Exception {

        Criteria cri = new Criteria();
        cri.setPage(2);
        cri.setPerPageNum(20);

        List<Board> boardList = boardDao.listCritera(cri);

        for(Board board : boardList) {
            logger.info("No." + board.getBno() + " | " + board.getTitle());
        }
    }
}
