package org.tukorea.free.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.persistence.UserDAO;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Transactional
public class UserDAOTest {

    @Autowired
    private UserDAO dao;

    private static Logger logger = LoggerFactory.getLogger(UserDAOTest.class);

    @Test
    public void testAddUser() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setId("test123");
        userVO.setPasswd("test_pw123");
        userVO.setJoinDate(new Date());

        dao.add(userVO);
//        logger.info(userVO.toString());
        logger.info(dao.read("test123").toString());
    }

    @Test
    public void testReadById() throws Exception {
        UserVO vo;
        vo = dao.read("admin");
        logger.info(vo.toString());
    }

    @Test
    public void testReadByName() throws Exception {
        UserVO vo;
        vo = dao.read("admin");
        logger.info(vo.toString());
    }

    @Test
    public void testReadList() throws Exception {
        List<UserVO> voList;
        voList = dao.readList();
        for (UserVO uvo : voList) {
            logger.info(uvo.toString());
        }
    }
}
