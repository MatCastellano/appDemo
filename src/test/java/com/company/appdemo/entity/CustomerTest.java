package com.company.appdemo.entity;


import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
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
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer= dataManager.create(Customer.class);
    }

    @Test
    void given_validCustomer_when_saveCustomer_then_customerIsSaved(){



        customer.setFirstName("Tutan");
        customer.setLastName("Kamon");
        customer.setEmail("tut@kam.it");
        customer.setAddress("via Eufrate 66");



        Customer cust=  systemAuthenticator.withSystem(() ->dataManager.save(customer) );





        assertThat(cust.getId()).isNotNull();
    }

/*    @Test
    void given_customerWithInvalidEmail_when_saveCustomer_then_customerIsSaved(){




        customer.setEmail("InvalidEmailAddress");


        Set<ConstraintViolation<Customer>> violations = validator.validate(customer, Default.class);


        assertThat(violations).hasSize(1);

        ConstraintViolation<Customer> emailViolations =firstViolation(violations);

        assertThat(emailViolations.getPropertyPath().toString()).isEqualTo("emailField");



        assertThat(emailViolations.getMessageTemplate()).isEqualTo("emailField");
    }

    private ConstraintViolation<Customer> firstViolation(Set<ConstraintViolation<Customer>> violations) {
        return violations.stream().findFirst().orElseThrow();
    }*/


}