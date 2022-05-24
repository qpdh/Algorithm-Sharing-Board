package org.tukorea.free.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.service.UserService;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Transactional
public class UserServiceTest {
    @Autowired
    UserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Test
    public void 유저찾기() throws Exception {
        UserVO vo;
        vo = userService.readUser("admin");
        logger.info(vo.toString());
    }

    @Test
    public void 유저리스트() throws Exception {
        List<UserVO> voList;
        voList = userService.readUserList();
        for (UserVO vo : voList) {
            logger.info(vo.toString());
        }
    }

    @Test
    public void 유저삽입() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setId("test1234");
        userVO.setPasswd("test_pw123");
        userVO.setJoinDate(new Date());

        userService.addUser(userVO);
//        logger.info(userVO.toString());
        logger.info(userService.readUser("test1234").toString());
    }

    @Test
    public void 중복회원() throws Exception {
        UserVO userVO = new UserVO();
        userVO.setId("hong123");
        userVO.setPasswd("test_pw123");
        userVO.setJoinDate(new Date());

        try{
            userService.addUser(userVO);
        }catch(DuplicateKeyException e){
            System.out.println("중복처리!");
        }
        logger.info(userService.readUser("hong123").toString());
    }
}
