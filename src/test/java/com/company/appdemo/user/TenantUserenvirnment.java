package com.company.appdemo.user;

import io.jmix.core.DataManager;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.AutoConfigureGraphQl;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;



public class TenantUserenvirnment implements BeforeEachCallback, AfterEachCallback {


    private Multitenancy multitenancy;


    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        ApplicationContext applicationContext = SpringExtension.getApplicationContext(context);

        multitenancy= applicationContext.getBean(Multitenancy.class);

        multitenancy.setup();

    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        multitenancy.end();
    }

}
