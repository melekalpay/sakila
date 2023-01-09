package com.uniyaz.staff.queryfilterdto;

import com.uniyaz.address.domain.Address;
import com.uniyaz.store.domain.Store;

public class StaffQueryFilterDto {
    private Long id;
    private String firstName;
    private Store store;
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
