package com.company.appdemo.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;
@JmixEntity
@Table(name = "ORDERLINE", indexes ={
        @Index(name = "IDX_ORDER_TAB_STOCKITEM_ID", columnList = "STOCKITEM"),
        @Index(name = "IDX_ORDER_TAB_ORDER_TAB_ID", columnList = "ORDERTAB")
})

@Entity
public class Orderline {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    @NotNull
    private UUID id;

    @JoinColumn(name = "STOCKITEM", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    private StockItem stockItem;


    @InstanceName
    @JoinColumn(name = "ORDERTAB", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Order_Tab order;


    @FutureOrPresent
    @NotNull
    @Column(name = "STARTSAT", nullable = false)
    private LocalDateTime start;


    @FutureOrPresent
    @NotNull
    @Column(name = "ENDSAT", nullable = false)
    private LocalDateTime end;



    public Order_Tab getOrder() {

        return order;
    }

    public void setOrder(Order_Tab order) {
        this.order = order;
    }


    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }



    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"order"})
    public String getInstanceName() {
        return String.format("%s", (order != null ? order : ""));
    }
}
