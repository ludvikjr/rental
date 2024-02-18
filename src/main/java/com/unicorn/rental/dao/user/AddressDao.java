package com.unicorn.rental.dao.user;

import com.unicorn.rental.domain.model.user.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends CrudRepository<Address, Integer> {
}
