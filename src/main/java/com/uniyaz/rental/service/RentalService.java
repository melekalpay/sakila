package com.uniyaz.rental.service;

import com.uniyaz.customer.dao.CustomerDao;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.rental.dao.RentalDao;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilterDto;

import java.util.List;

public class RentalService {
        public List<Rental> findAll() {
            RentalDao rentalDao = new RentalDao();
            return rentalDao.findAll();
        }
    public List<Rental> findAllByQueryFilterDto(RentalQueryFilterDto rentalQueryFilterDto) {
        RentalDao rentalDao = new RentalDao();
        return rentalDao.findAllByQueryFilterDto(rentalQueryFilterDto);
    }

    public List<Rental> findAllByQueryFilterDtoCriteria(RentalQueryFilterDto rentalQueryFilterDto) {
        RentalDao rentalDao = new RentalDao();
        return rentalDao.findAllByQueryFilterDtoCriteria(rentalQueryFilterDto);
    }
}
