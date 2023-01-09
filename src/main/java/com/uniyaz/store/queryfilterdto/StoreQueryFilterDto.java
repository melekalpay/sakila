package com.uniyaz.store.queryfilterdto;

import com.uniyaz.address.domain.Address;
import com.uniyaz.staff.domain.Staff;

public class StoreQueryFilterDto {
    private Long id;
    private Address address;
    private Staff staff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
