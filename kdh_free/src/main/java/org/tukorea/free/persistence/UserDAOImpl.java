package org.tukorea.free.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.UserVO;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "org.tukorea.free.mapper.UserMapper";

    @Override
    public void add(UserVO user) throws Exception {
        sqlSession.insert(namespace + ".insert", user);
        sqlSession.insert(namespace + ".insert2", user);
    }

    @Override
    public UserVO read(String id) throws Exception {
        UserVO vo = sqlSession.selectOne(namespace + ".selectById", id);
        return vo;
    }

    @Override
    public List<UserVO> readList() throws Exception {
        List<UserVO> userList = new ArrayList<>();
        userList = sqlSession.selectList(namespace + ".selectAll");
        return userList;
    }

    @Override
    public void delete(String id) throws Exception {
        sqlSession.delete(namespace + ".delete", id);
    }
}
