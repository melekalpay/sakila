package com.uniyaz.customer.service;

import com.uniyaz.category.dao.CategoryDao;
import com.uniyaz.category.domain.Category;
import com.uniyaz.category.queryfilterdto.CategoryQueryFilterDto;
import com.uniyaz.customer.dao.CustomerDao;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilterDto;
import com.uniyaz.film_category.dao.FilmCategoryDao;
import com.uniyaz.film_category.domain.FilmCategory;

import java.util.List;

public class CustomerService {
        public List<Customer> findAll() {
            CustomerDao customerDao=new CustomerDao();
            return customerDao.findAll();
        }

    public List<Customer> findAllByQueryFilterDto(CustomerQueryFilterDto customerQueryFilterDto) {
        CustomerDao customerDao= new CustomerDao();
        return customerDao.findAllByQueryFilterDto(customerQueryFilterDto);
    }

    public List<Customer> findAllByQueryFilterDtoCriteria(CustomerQueryFilterDto customerQueryFilterDto) {
        CustomerDao customerDao= new CustomerDao();
        return customerDao.findAllByQueryFilterDtoCriteria(customerQueryFilterDto);
    }

}
