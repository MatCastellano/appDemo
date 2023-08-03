package com.company.appdemo.screen.customer;

import io.jmix.core.FileRef;
import io.jmix.ui.Notifications;
import io.jmix.ui.Screens;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.FileMultiUploadField;
import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Customer;
import io.jmix.ui.upload.TemporaryStorage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.UUID;

@UiController("Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
public class CustomerBrowse extends StandardLookup<Customer> {
   /* @Subscribe("uploadButton")
    public void onUploadButtonClick(Button.ClickEvent event) {
    }

    @Subscribe
    public void onBeforeClose(BeforeCloseEvent event) {

    }*/



}