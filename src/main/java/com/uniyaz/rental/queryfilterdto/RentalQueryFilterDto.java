package com.uniyaz.rental.queryfilterdto;

import com.uniyaz.customer.domain.Customer;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.staff.domain.Staff;

public class RentalQueryFilterDto {

    private Long id;
    private Inventory inventory;
    private Customer customer;
    private Staff staff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
