package org.tukorea.free.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.persistence.PostDAO;

import java.util.Date;
import java.util.List;

@Qualifier("algoService")
@Service
public class AlgorithmPostServiceImpl implements PostService {
    @Autowired
    @Qualifier("algo")
    PostDAO postDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, timeout = 10)
    public PostVO readPost(Integer id) throws Exception {
        PostVO vo = postDAO.read(id);
        return vo;
    }

    @Override
    public List<PostVO> readPostList() throws Exception {
        List<PostVO> voList = postDAO.readList();
        return voList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 10)
    public void addPost(PostVO post) throws Exception {
        post.setPostDate(new Date());
        postDAO.add(post);
    }

    @Override
    public void updatePost(PostVO postVO) throws Exception {
        postDAO.update(postVO);
    }

    @Override
    public void deletePost(Integer id) throws Exception {
        postDAO.delete(id);
    }
}
