package com.company.appdemo.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "CALENDAR")
@Entity
public class Calendar {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "CAPTION", nullable = false)
    private String caption;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "STARTDATE", nullable = false)
    private Date startDate;


    @Column(name = "ENDDATE", nullable = false)
    private Date endDate;



    @Column(name = "STYLENAME", nullable = false)
    private String stylename;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStylename() {
        return stylename;
    }

    public void setStylename(String stylename) {
        this.stylename = stylename;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}