package ProjectR2s.App.service;

import ProjectR2s.App.dto.AddressDto;
import ProjectR2s.App.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    List<Address> getAllAddressesByUserId(Long userId);
    Address getAddressById(Long addressId);
    Address addAddress(Long userId, AddressDto addressDto);

    Address createAddress(AddressDto addressDto);

    Address updateAddress(Long addressId, AddressDto addressDto);
    void deleteAddress(Long addressId);

    List<AddressDto> getUserAddresses(Long userId);
}
