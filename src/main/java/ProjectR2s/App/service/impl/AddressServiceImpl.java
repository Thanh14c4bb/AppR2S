package ProjectR2s.App.service.impl;

import ProjectR2s.App.dto.AddressDto;
import ProjectR2s.App.entity.Address;
import ProjectR2s.App.repository.AddressRepository;
import ProjectR2s.App.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public List<Address> getAllAddressesByUserId(Long userId) {
        return null;
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new IllegalArgumentException("Address not found"));
    }

    @Override
    public Address addAddress(Long userId, AddressDto addressDto) {
        return null;
    }

    @Override
    public Address createAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, AddressDto addressDto) {
        Address existingAddress = getAddressById(id);
        existingAddress.setStreet(addressDto.getStreet());
        existingAddress.setCity(addressDto.getCity());
        return addressRepository.save(existingAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public List<AddressDto> getUserAddresses(Long userId) {
        return null;
    }
}


