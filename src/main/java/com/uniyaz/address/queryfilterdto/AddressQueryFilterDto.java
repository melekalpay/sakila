package com.uniyaz.address.queryfilterdto;

import com.uniyaz.city.domain.City;

public class AddressQueryFilterDto {
    private Long id;
    private String district;
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
