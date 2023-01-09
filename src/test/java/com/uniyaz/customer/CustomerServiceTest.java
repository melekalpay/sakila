package com.uniyaz.customer;

import com.uniyaz.address.domain.Address;
import com.uniyaz.address.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.address.service.AddressService;
import com.uniyaz.category.queryfilterdto.CategoryQueryFilterDto;
import com.uniyaz.city.domain.City;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilterDto;
import com.uniyaz.customer.service.CustomerService;
import com.uniyaz.film_category.domain.FilmCategory;
import com.uniyaz.film_category.service.FilmCategoryService;
import com.uniyaz.store.domain.Store;
import org.junit.Test;

import java.util.List;

public class CustomerServiceTest {
    @Test
    public void findAllTest() {

        CustomerService customerService = new CustomerService();
        List<Customer> customers = customerService.findAll();
        for (Customer customer : customers) {
            System.out.println(customer); }
    }

    @Test
    public void findAllByQueryFilterDto(){
        CustomerQueryFilterDto customerQueryFilterDto = new CustomerQueryFilterDto();
        CustomerService customerService = new CustomerService();
        Store store = new Store();
        store.setId(1L);
        String name="barbara";
        customerQueryFilterDto.setFirstName(name);

        List<Customer> customers = customerService.findAllByQueryFilterDto(customerQueryFilterDto);
        for (Customer customer : customers) {
            System.out.println(customer); }

    }

    @Test
    public void findAllByQueryFilterDtoCriteria(){
        CustomerQueryFilterDto customerQueryFilterDto = new CustomerQueryFilterDto();
        CustomerService customerService = new CustomerService();
        Store store = new Store();
        store.setId(1L);
        String name="barbara";
        Address address=new Address();
        address.setDistrict("Jalisco");
        customerQueryFilterDto.setAddress(address);

        List<Customer> customers = customerService.findAllByQueryFilterDtoCriteria(customerQueryFilterDto);
        for (Customer customer : customers) {
            System.out.println(customer); }

    }
}
