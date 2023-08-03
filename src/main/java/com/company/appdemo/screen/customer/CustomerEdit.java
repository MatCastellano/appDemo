package com.company.appdemo.screen.customer;

import io.jmix.core.FileRef;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.FileMultiUploadField;
import io.jmix.ui.component.FileStorageUploadField;
import io.jmix.ui.component.SingleFileUploadField;
import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Customer;
import io.jmix.ui.upload.TemporaryStorage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Map;
import java.util.UUID;

@UiController("Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {

    @Autowired
    private FileStorageUploadField documentField;

    @Autowired
    private TemporaryStorage temporaryStorage;

    private Customer customer;


    @Subscribe("documentField")
    public void FileUpload(SingleFileUploadField.FileUploadSucceedEvent event) {
        File file = temporaryStorage.getFile(documentField.getFileId());
        FileRef fileRef = null;
        if (file != null) {
            fileRef = temporaryStorage.putFileIntoStorage(documentField.getFileId(), event.getFileName());
            documentField.setValue(fileRef);
        }


    }
}
