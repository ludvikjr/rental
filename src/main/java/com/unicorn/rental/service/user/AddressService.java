package com.unicorn.rental.service.user;

import com.unicorn.rental.dao.user.AddressDao;
import com.unicorn.rental.domain.model.user.Address;
import com.unicorn.rental.domain.requestTypes.AddressRequestType;
import com.unicorn.rental.helpers.exceptions.BodyMissingRequiredParamsException;
import com.unicorn.rental.helpers.exceptions.ItemNotFoundException;
import com.unicorn.rental.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressDao addressDao;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressDao addressDao, AddressMapper addressMapper) {
        this.addressDao = addressDao;
        this.addressMapper = addressMapper;
    }

    public Address createAddress(AddressRequestType addressRequestType) {
        Address newAddress = addressMapper.addressRequestTypeToAddress(addressRequestType);

        if (newAddress.getStreet() == null)
            throw new BodyMissingRequiredParamsException();

        return addressDao.save(newAddress);
    }
}
