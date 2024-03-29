package org.tukorea.free.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.persistence.UserDAO;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserVO readUser(String id) throws Exception {
        return userDAO.read(id);
    }

    @Override
    public List<UserVO> readUserList() throws Exception {
        return userDAO.readList();
    }

    @Override
    public void addUser(UserVO user) throws Exception {
        String password = user.getPasswd();

        // 디비에 저장할 비밀번호 암호화
        String encrypted = BCrypt.hashpw(password, BCrypt.gensalt());

        user.setPasswd(encrypted);

        userDAO.add(user);
    }

    @Override
    public void deleteUser(String id) throws Exception {
        userDAO.delete(id);
    }
}
