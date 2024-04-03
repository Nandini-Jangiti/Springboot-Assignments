package com.ust.empapp.service;

import com.ust.empapp.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();
    Address createAddress(Address address);

    Address getAddressById(Long addressId);

    Address updateAddress(Long addressId, Address address);

    void deleteAddress(Long id);
}
