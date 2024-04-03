package com.ust.empapp.service;

import com.ust.empapp.entity.Address;
import com.ust.empapp.exception.NotFoundException;
import com.ust.empapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }
    @Override
    public Address getAddressById(Long id) {
        try {
            return addressRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Address not found with id: " + id));
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public Address updateAddress(Long addressId, Address address) {
        if (!addressRepository.existsById(addressId)) {
            try {
                throw new NotFoundException("Address not found with id: " + addressId);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        address.setAddressId(addressId);
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            try {
                throw new NotFoundException("Address not found with id: " + id);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        addressRepository.deleteById(id);
    }
}
