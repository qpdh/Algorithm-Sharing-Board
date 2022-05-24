package org.tukorea.free.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.persistence.PostDAO;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataStructureDAOTest {

    @Qualifier("data")
    @Autowired
    private PostDAO dao;

    private static Logger logger = LoggerFactory.getLogger(DataStructureDAOTest.class);

    @Test
    public void testReadById() throws Exception {
        PostVO vo;
        vo = dao.read(1);
        logger.info(vo.toString());
    }

    @Test
    public void testReadList() throws Exception {
        List<PostVO> voList;
        voList = dao.readList();
        for (PostVO uvo : voList) {
            logger.info(uvo.toString());
        }
    }
}
