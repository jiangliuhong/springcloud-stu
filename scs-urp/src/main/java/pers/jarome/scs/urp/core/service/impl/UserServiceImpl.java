package pers.jarome.scs.urp.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.jarome.scs.urp.core.dao.UserDao;
import pers.jarome.scs.urp.core.model.User;
import pers.jarome.scs.urp.core.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.insert(user);
    }
}
