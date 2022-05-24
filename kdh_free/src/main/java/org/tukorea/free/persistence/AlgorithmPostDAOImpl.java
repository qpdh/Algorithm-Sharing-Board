package org.tukorea.free.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.PostVO;

import java.util.ArrayList;
import java.util.List;

@Qualifier("algo")
@Repository
public class AlgorithmPostDAOImpl implements PostDAO {
    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "org.tukorea.free.mapper.AlgorithmPostMapper";

    @Override
    public void add(PostVO postVO) throws Exception {
        sqlSession.insert(namespace + ".insert", postVO);
    }

    @Override
    public PostVO read(Integer id) throws Exception {
        PostVO postVO = sqlSession.selectOne(namespace + ".selectById", id);
        return postVO;
    }

    @Override
    public List<PostVO> readList() throws Exception {
        List<PostVO> voList = new ArrayList<>();
        voList = sqlSession.selectList(namespace + ".selectAll");
        return voList;
    }

    @Override
    public void update(PostVO post) throws Exception {
        sqlSession.update(namespace + ".update", post);
    }

    @Override
    public void delete(Integer id) throws Exception {
        sqlSession.delete(namespace + ".delete", id);
    }
}
