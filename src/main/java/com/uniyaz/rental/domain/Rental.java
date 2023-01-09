package com.uniyaz.rental.domain;

import com.uniyaz.customer.domain.Customer;
import com.uniyaz.domain.common.BaseEntity;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.staff.domain.Staff;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "rental")
public class Rental extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rental_date")
    private Date rentalDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    @ForeignKey(name = "fk_rental_inventory")
    private Inventory inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @ForeignKey(name = "fk_rental_customer")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    @ForeignKey(name = "fk_rental_staff")
    private Staff staff;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_date")
    private Date returnDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", rentalDate=" + rentalDate +
                ", inventory=" + inventory.getId() +
                ", customer=" + customer.getFirstName() +
                ", staff=" + staff.getFirstName() +
                ", returnDate=" + returnDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
