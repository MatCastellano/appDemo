package com.company.appdemo.entity;

import groovyjarjarpicocli.CommandLine;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "DOCUMENT_CATEGORY")
@Entity
public class DocumentCategory {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "Tipologia", nullable = false)
    private String tipologia;

    @Column(name = "Scadenza", nullable = false)
    private LocalDate scadenza;

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    @DependsOnProperties({"tipologia"})
    public String getDisplayName() {
        return String.format("%s", (tipologia != null ? tipologia : ""),
                (tipologia != null ? tipologia : "").trim());
    }
}