package org.tukorea.free.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.free.domain.LanguageVO;
import org.tukorea.free.persistence.LanguageDAO;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class LanguageDAOTest {

    @Autowired
    private LanguageDAO dao;

    private static Logger logger = LoggerFactory.getLogger(LanguageDAOTest.class);

    @Test
    public void testReadByLanguage() throws Exception {
        LanguageVO vo;
        vo = dao.read("java");
        logger.info(vo.toString());
    }

    @Test
    public void testReadList() throws Exception {
        List<LanguageVO> voList;
        voList = dao.readList();
        for (LanguageVO uvo : voList) {
            logger.info(uvo.toString());
        }
    }
}
