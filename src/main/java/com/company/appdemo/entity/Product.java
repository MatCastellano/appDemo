package com.company.appdemo.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "PRODUCT")
@Entity
public class Product {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;


    @InstanceName
    @Column(name = "P_NAME", nullable = false)
    @NotNull
    private String p_name;



    @Column(name = "DESCRIPTION", nullable = false)
    @NotNull
    private String description;


    /*@Column(name = "PRICE", nullable = false)
    private Double price;
*/



    @JoinColumn(name = "CATEGORY")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCategory category;


    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "product")
    private List<StockItem> stockItems;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "product")
    private List<Price> prices;

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<StockItem> stockItems) {
        this.stockItems = stockItems;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    /*public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
*/
    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    @InstanceName
    @DependsOnProperties({"p_name"})
    public String getDisplayName() {
        return String.format("%s", (p_name != null ? p_name : ""),
                (p_name != null ? p_name : "").trim());
    }
}