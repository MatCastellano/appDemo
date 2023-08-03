package com.company.appdemo.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ORDER_TAB", indexes = {
        @Index(name = "IDX_ORDER_TAB_CUSTOMER_ID", columnList = "CUSTOMER")
})
@Entity(name = "ORDER_TAB")
public class Order_Tab {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;



    @FutureOrPresent
    @NotNull
    @Column(name = "DATE",nullable = false)
    private LocalDate date;


    @InstanceName
    @JoinColumn(name = "CUSTOMER", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Customer customer;


    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "order")

    private List<Orderline> orderline;


    public List<Orderline> getOrderline() {
        return orderline;
    }

    public void setOrderline(List<Orderline> orderline) {
        this.orderline = orderline;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"date", "customer"})
    public String getDisplayName() {
        return String.format("%s %s ", (date != null ? date : ""),
                (customer != null ? customer : ""));
    }

}