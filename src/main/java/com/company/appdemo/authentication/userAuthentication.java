package com.company.appdemo.authentication;


import com.company.appdemo.entity.User;
import com.vaadin.data.validator.EmailValidator;
import io.jmix.securityui.password.PasswordValidationContext;
import io.jmix.securityui.password.PasswordValidationException;
import io.jmix.securityui.password.PasswordValidator;
import io.jmix.ui.screen.Subscribe;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.awt.*;


@Component
public class userAuthentication implements PasswordValidator<User> {

    private User user;

    protected TextField emailField;

    @Autowired
    protected ApplicationContext applicationContext;


    @Subscribe
    protected void emailValidator(EmailValidator emailValidator) throws Exception{
        emailValidator= applicationContext.getBean(EmailValidator.class);
        emailField.validate();

    }



    @Override
    public void validate(@NotNull PasswordValidationContext<User> passwordValidationContext) throws PasswordValidationException {
        if(passwordValidationContext.getPassword().length()<=3 || passwordValidationContext.getPassword()==null){
            throw new PasswordValidationException("Error Password");
        }
    }

}
