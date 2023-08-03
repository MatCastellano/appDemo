package com.company.appdemo.entity;

import groovy.transform.builder.Builder;
import groovyjarjarpicocli.CommandLine;
import io.jmix.core.FileRef;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.annotation.Secret;
import io.jmix.core.entity.annotation.EmbeddedParameters;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.SystemLevel;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.PropertyDatatype;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.AttachEvent;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.FileMultiUploadField;
import io.jmix.ui.download.DownloadFormat;
import io.jmix.ui.download.Downloader;
/*import me.zhengjin.common.attachment.po.Attachment;*/
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;

import io.jmix.ui.upload.TemporaryStorage;
import org.checkerframework.common.aliasing.qual.Unique;
import org.eclipse.persistence.annotations.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.swing.text.Document;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "CUSTOMER")
public class Customer {



    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "FIRST_NAME", nullable = false)
    @NotNull
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    @NotNull
    private String lastName;


    @Column(name = "EMAIL", nullable = false)
    @Email
    private String email;





    @Column(name = "ADDRESS", nullable = false)
    private String address;



    @Column(name = "DOCUMENT", length = 1024)
    private FileRef document;


    @JoinColumn(name = "CATEGORYDOC")
    @ManyToOne(fetch = FetchType.LAZY)
    private DocumentCategory category;

    /* @EmbeddedParameters(nullAllowed = false)
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "street", column = @Column(name = "ADDRESS STREET")),
            @AttributeOverride(name = "postcode", column = @Column(name = "ADDRESS POST_CODE")),
            @AttributeOverride(name = "city", column = @Column(name = "ADDRESS
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
*/

    public DocumentCategory getCategory() {
        return category;
    }

    public void setCategory(DocumentCategory category) {
        this.category = category;
    }

    public FileRef getDocument() {
        return document;
    }

    public void setDocument(FileRef document) {
        this.document = document;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    @InstanceName
    @DependsOnProperties({"firstName", "lastName"})
    public String getDisplayName() {
        return String.format("%s %s ", (firstName != null ? firstName : ""),
                (lastName != null ? lastName : "").trim());
    }









}