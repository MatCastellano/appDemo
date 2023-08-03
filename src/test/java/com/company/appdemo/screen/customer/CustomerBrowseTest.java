package com.company.appdemo.screen.customer;

import com.company.appdemo.AppDemoApplication;
import com.company.appdemo.entity.Customer;
import io.jmix.core.DataManager;
import io.jmix.ui.Screens;
import io.jmix.ui.component.Table;
import io.jmix.ui.testassist.UiTestAssistConfiguration;
import io.jmix.ui.testassist.junit.UiTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@UiTest(authenticatedUser = "admin", mainScreenId ="MainScreen", screenBasePackages = "com.company.appdemo")
@ContextConfiguration(classes = {AppDemoApplication.class, UiTestAssistConfiguration.class})
@AutoConfigureTestDatabase
class CustomerBrowseTest {

    @Autowired
    DataManager dataManager;
    private Customer customer;

    @BeforeEach
    void setUp() {
       customer=  dataManager.create(Customer.class);
       customer.setFirstName("Fop");
       customer.setLastName("Bar");
       customer.setEmail("foo@bar.it");
       customer.setAddress("Via delle vie 21");


       dataManager.save(customer);
    }

    @Test
    void given_oneCustomerExist_when_openCustomerBrowse_then_tableContainTheCustomer(Screens screens){

        //given
        CustomerBrowse customerBrowse = openCustomerBrowse(screens);


        //expect


        Customer firstCust= firstCustomer(customerBrowse);
        assertThat(firstCust).isEqualTo(customer);

        //Controllo classe
        //assertThat(screens.getOpenedScreens().getActiveScreens().stream().findFirst().orElseThrow()).isInstanceOf(CustomerEdit.class);

    }

    @NotNull

    private Customer firstCustomer(CustomerBrowse customerBrowse) {
        Collection<Customer> customers= loadedCustomers(customerBrowse);

        return customers.stream().findFirst().orElseThrow();
    }


    @NotNull
    private Collection<Customer> loadedCustomers(CustomerBrowse customerBrowse) {
        Table<Customer> customerTable= customerTable(customerBrowse);
        return customerTable.getItems().getItems();
    }


    @NotNull
    private CustomerBrowse openCustomerBrowse(Screens screens) {
        CustomerBrowse customerBrowse = screens.create(CustomerBrowse.class);
        return customerBrowse;
    }


    @Nullable
    private Table<Customer> customerTable(CustomerBrowse customerBrowse) {

        return (Table<Customer>) customerBrowse.getWindow().getComponent("customersTable");

    }


    @AfterEach
    void tearDown() {
        dataManager.remove(customer);
    }
}