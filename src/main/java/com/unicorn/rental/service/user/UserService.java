package com.unicorn.rental.service.user;

import com.unicorn.rental.dao.user.CityDao;
import com.unicorn.rental.dao.user.UserDao;
import com.unicorn.rental.domain.dto.UserDto;
import com.unicorn.rental.domain.model.user.Address;
import com.unicorn.rental.domain.model.user.User;
import com.unicorn.rental.domain.requestTypes.UserRequestType;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import com.unicorn.rental.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    private final UserMapper userMapper;

    private final AddressService addressService;

    private final CityDao cityDao;

    @Autowired
    public UserService(UserDao userDao, UserMapper userMapper, AddressService addressService, CityDao cityDao) {
        this.userDao = userDao;
        this.userMapper = userMapper;
        this.addressService = addressService;
        this.cityDao = cityDao;
    }

    @Transactional
    public List<UserDto> listUsers() {
        return userMapper.userListToUserDtoList((List<User>)userDao.findAll());
    }

    public User createUser(UserRequestType userRequestType) {

        if (userRequestType.getFullName() == null)
            throw new BodyMissingRequiredParamsException();

        if (cityDao.findById(userRequestType.getAddress().getCityId()).isEmpty())
            throw new ItemNotFoundException();

        Address address = addressService.createAddress(userRequestType.getAddress());

        User user = new User(userRequestType.getFullName(), address);

        return userDao.save(user);
    }

}
