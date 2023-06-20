package com.company.appdemo.screen.customer;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Customer;

@UiController("Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {
}