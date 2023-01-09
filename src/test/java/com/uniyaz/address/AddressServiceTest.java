package com.uniyaz.address;

import com.uniyaz.address.domain.Address;
import com.uniyaz.address.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.address.service.AddressService;
import com.uniyaz.city.domain.City;
import org.junit.Test;

import java.util.List;

public class AddressServiceTest {
    @Test
    public void findAll(){
        AddressService addressService = new AddressService();
        List<Address> addresses = addressService.findAll();
        for (Address address : addresses) {
            System.out.println(address);
        }

    }

    @Test
    public void findAllByQueryFilterDto(){
        AddressQueryFilterDto addressQueryFilterDto = new AddressQueryFilterDto();
        AddressService addressService = new AddressService();
        //addressQueryFilterDto.setId(1L);
        City city = new City();
        city.setCity("al-Qatif");

        addressQueryFilterDto.setCity(city);
        List<Address> addresses = addressService.findAllByQueryFilterDto(addressQueryFilterDto);
        for (Address address : addresses) {
            System.out.println(address);
        }
    }

    @Test
    public void findAllByQueryCriteria(){
        AddressService addressService = new AddressService();
        String city="al-Qatif";
        List<Address> addresses = addressService.findAllByQueryFilterDtoDetachedCriteria(city);
        for (Address address : addresses) {
            System.out.println(address);
        }
    }
}
