package com.uniyaz.payment.queryfilterdto;

import com.uniyaz.customer.domain.Customer;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.staff.domain.Staff;

public class PaymentQueryFilterDto {
    private Long id;
    private Customer customer;
    private Rental rental;
    private Staff staff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
