package com.unicorn.rental.service.user;

import com.unicorn.rental.dao.user.UserDao;
import com.unicorn.rental.domain.dto.UserDto;
import com.unicorn.rental.domain.model.user.User;
import com.unicorn.rental.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    public List<UserDto> listUsers() {
        return userMapper.userListToUserDtoList((List<User>)userDao.findAll());
    }
}
