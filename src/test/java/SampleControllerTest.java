/******************************************************
 * Project Name :  spring_board
 * File Name : SampleControllerTest.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 8. 25. 오전 2:16
 * Description :
 ******************************************************/

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
        //locations={"file:/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
        locations = {"file:/spring_board/board/src/main/webapp/WEB-INF/mvc-*.xml"})

public class SampleControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);

    @Inject
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        logger.info("setup..............");
    }

    @Test
    public void testDoA() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doE"));
    }



    @Test
    public void testException() {

        try {
            logger.info(">>>>>>>>>>testException!!!!");
            callA();
            throw new Exception();
        } catch (Exception e) {

            logger.info("1111111111111");

        }
    }

    private static void callA() throws Exception {
        try {

            throw new NumberFormatException();
        }catch (NumberFormatException e) {

            logger.info("2222222222222222");
        }
    }
}
