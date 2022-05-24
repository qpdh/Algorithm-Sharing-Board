package org.tukorea.free.service;

import org.tukorea.free.domain.UserVO;

import java.util.List;

public interface UserService {
    public UserVO readUser(String id) throws Exception;
    public List<UserVO> readUserList() throws Exception;
    public void addUser(UserVO user) throws Exception;
    public void deleteUser(String id) throws Exception;
}
