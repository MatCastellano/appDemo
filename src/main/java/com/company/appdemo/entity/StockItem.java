package com.company.appdemo.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "STOCK_ITEM")
@Entity
public class StockItem {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;


    @InstanceName
    @NotBlank
    @Column(name = "IDENTIFIER", nullable = false)
    private String identifier;


    @NotNull
    @JoinColumn(name = "PRODUCT", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"identifier"})
    public String getDisplayName() {
        return String.format("%s", (identifier != null ? identifier : ""),
                (identifier != null ? identifier : "").trim());
    }
}