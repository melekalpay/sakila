package com.uniyaz.customer.queryfilterdto;

import com.uniyaz.address.domain.Address;
import com.uniyaz.store.domain.Store;

public class CustomerQueryFilterDto {
    private Address address;
    private String firstName;
    private Store store;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
}
