package org.tukorea.free.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.service.PostService;
import org.tukorea.free.service.UserService;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Transactional
public class DataStructureServiceTest {
    @Autowired
    @Qualifier("dataService")
    PostService postService;

    private static Logger logger = LoggerFactory.getLogger(DataStructureServiceTest.class);

    @Test
    public void 게시글_불러오기() throws Exception{
        List<PostVO> voList = postService.readPostList();
        for(PostVO vo : voList){
            logger.info(vo.toString());
        }
    }
}
