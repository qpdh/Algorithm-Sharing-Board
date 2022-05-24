package org.tukorea.free.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.LanguageVO;

import java.util.LinkedList;
import java.util.List;

@Repository
public class LanguageDAOImpl implements LanguageDAO {
    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "org.tukorea.free.mapper.LanguageMapper";

    @Override
    public LanguageVO read(String id) throws Exception {
        LanguageVO result = sqlSession.selectOne(namespace + ".selectById", id);
        return result;
    }

    @Override
    public List<LanguageVO> readList() throws Exception {
        List<LanguageVO> languageList = new LinkedList<>();
        languageList = sqlSession.selectList(namespace + ".selectAll");
        return languageList;
    }
}
