package com.unicorn.rental.service;

import com.unicorn.rental.dao.user.CityDao;
import com.unicorn.rental.dao.user.UserDao;
import com.unicorn.rental.domain.model.user.User;
import com.unicorn.rental.domain.requestTypes.AddressRequestType;
import com.unicorn.rental.domain.requestTypes.UserRequestType;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import com.unicorn.rental.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Test
    public void listUsersSuccessful() {
        assertDoesNotThrow(() -> userService.listUsers());
        assertFalse(userService.listUsers().isEmpty());
    }

    @Test
    public void createUserSuccessful() {

        UserRequestType newUserRequestType = UserRequestType
                .builder()
                .address(AddressRequestType
                        .builder()
                        .building(1)
                        .cityId(1)
                        .street("asd")
                        .build())
                .fullName("Jane Doe")
                .build();

        assertDoesNotThrow(() -> userService.createUser(newUserRequestType));

        User savedUser = userDao.findById(2).orElse(null);

        assertNotNull(savedUser);
        assertEquals(savedUser.getAddress().getCity().getId(), 1);
        assertEquals(savedUser.getAddress().getBuilding(), 1);
        assertEquals(savedUser.getAddress().getStreet(), "asd");
        assertEquals(savedUser.getFullName(), "Jane Doe");

    }

    @Test
    public void createCarCityIdMissing() {

        UserRequestType newUserRequestType = UserRequestType
                .builder()
                .address(AddressRequestType
                        .builder()
                        .building(1)
                        .street("asd")
                        .build())
                .fullName("Jane Doe")
                .build();

        assertThrows(ItemNotFoundException.class, () -> userService.createUser(newUserRequestType));
    }

    @Test
    public void createCarStreetMissing() {
        UserRequestType newUserRequestType = UserRequestType
                .builder()
                .address(AddressRequestType
                        .builder()
                        .cityId(1)
                        .building(1)
                        .build())
                .fullName("Jane Doe")
                .build();

        assertThrows(BodyMissingRequiredParamsException.class, () -> userService.createUser(newUserRequestType));
    }

    @Test
    public void createCarFullNameMissing() {
        UserRequestType newUserRequestType = UserRequestType
                .builder()
                .address(AddressRequestType
                        .builder()
                        .cityId(1)
                        .street("asd")
                        .building(1)
                        .build())
                .build();

        assertThrows(BodyMissingRequiredParamsException.class, () -> userService.createUser(newUserRequestType));
    }
}
