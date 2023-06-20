package com.company.appdemo.entity;


import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerIntegrationTest {

    @Autowired
    DataManager dataManager;

    @Autowired
    SystemAuthenticator systemAuthenticator;

    @Autowired
    Validator validator;
    @Test
    void given_validCustomer_when_saveCustomer_then_customerIsSaved(){

        Customer customer= dataManager.create(Customer.class);

        customer.setFirstName("Foo");
        customer.setLastName("Bar");
        customer.setEmail("fo@ba.it");
        customer.setAddress("via delle vie 10");
        customer.setPassword("1235");


        Customer cust=  systemAuthenticator.withSystem(() ->dataManager.save(customer) );





        assertThat(cust.getId()).isNotNull();
    }

    @Test
    void given_customerWithInvalidEmail_when_saveCustomer_then_customerIsSaved(){

        Customer customer= dataManager.create(Customer.class);


        customer.setEmail("Invalid email");


        Set<ConstraintViolation<Customer>> violations = validator.validate(customer, Default.class);


        assertThat(violations).hasSize(1);

        ConstraintViolation<Customer> emailViolations = violations.stream().findFirst().orElseThrow();

        assertThat(emailViolations.getPropertyPath().toString()).isEqualTo("email");



        assertThat(emailViolations.getMessageTemplate()).isEqualTo("email");
    }
}