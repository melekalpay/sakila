package com.uniyaz.payment.domain;

import com.uniyaz.customer.domain.Customer;
import com.uniyaz.domain.common.BaseEntity;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.staff.domain.Staff;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @ForeignKey(name = "fk_payment_customer")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    @ForeignKey(name = "fk_payment_staff")
    private Staff staff;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    @ForeignKey(name = "fk_payment_rental")
    private Rental rental;

    @Column(name = "amount")
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date")
    private Date paymentDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", customer=" + customer.getFirstName() +
                ", staff=" + staff.getFirstName() +
                ", rental=" + rental.getId() +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
