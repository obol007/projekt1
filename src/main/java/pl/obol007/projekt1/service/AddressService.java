package pl.obol007.projekt1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.obol007.projekt1.domain.model.Address;
import pl.obol007.projekt1.domain.model.Product;
import pl.obol007.projekt1.domain.repositories.AddressRepository;
import pl.obol007.projekt1.dto.AddressDTO;

import java.util.Optional;

@Service
@Transactional
public class AddressService {
    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO findAddress(Long id) {
//getOne(id)
        AddressDTO addressDTO = new AddressDTO();
        Optional<Address> optionalAddress = addressRepository.findAddressByUserId(id);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            addressDTO.setId(address.getId());
            addressDTO.setBuildingNumber(address.getBuildingNumber());
            addressDTO.setCity(address.getCity());
            addressDTO.setCountry(address.getCountry());
            addressDTO.setFlatNumber(address.getFlatNumber());
            addressDTO.setStreet(address.getStreet());
            addressDTO.setZipcode(address.getZipcode());
            return addressDTO;
        }
        return new AddressDTO();

    }

    public void save(AddressDTO addressDTO) {
        Optional<Address> optionalAddress = addressRepository.findById(addressDTO.getId());
        if(optionalAddress.isPresent()){
            Address address = optionalAddress.get();
            address.setBuildingNumber(addressDTO.getBuildingNumber());
            address.setCity(addressDTO.getCity());
            address.setCountry(addressDTO.getCountry());
            address.setFlatNumber(addressDTO.getFlatNumber());
            address.setStreet(addressDTO.getStreet());
            address.setZipcode(addressDTO.getZipcode());
            addressRepository.save(address);
        }
    }
}
