package com.uniyaz.store.domain;

import com.uniyaz.address.domain.Address;
import com.uniyaz.domain.common.BaseEntity;
import com.uniyaz.staff.domain.Staff;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "store")
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_staff_id")
    @ForeignKey(name = "fk_store_staff")
    private Staff staff;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @ForeignKey(name = "fk_store_address")
    private Address address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", staff=" + staff +
                ", address=" + address +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
