package org.tukorea.free.persistence;

import org.tukorea.free.domain.UserVO;

import java.util.List;

public interface UserDAO {
    public void add(UserVO user) throws Exception;


    public UserVO read(String id) throws Exception;
    public List<UserVO> readList() throws Exception;

    public void delete(String id) throws Exception;
}
