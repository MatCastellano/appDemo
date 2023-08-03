package com.company.appdemo.screen.email;

import com.company.appdemo.EmailSending;
import io.jmix.core.Resources;
import io.jmix.email.EmailInfo;
import io.jmix.email.EmailInfoBuilder;
import io.jmix.email.Emailer;
import io.jmix.ui.Dialogs;
import io.jmix.ui.action.DialogAction;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Email;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import javax.inject.Inject;
import javax.mail.Session;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Logger;

@UiController("Email.edit")
@UiDescriptor("email-edit.xml")
@EditedEntityContainer("emailDc")
public class EmailEdit extends StandardEditor<Email> {

    private boolean created;

    @Autowired
    private Emailer emailer;

    @Autowired
    private Resources resources;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Email> event){
        created=true;
    }

   /* private String user;

    private String pw;

    public EmailEdit(String username, String password) {
        super();
        this.user = username;
        this.pw= password;
    }


    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(user, pw.toCharArray());
    }
*/


    @Inject
    protected Dialogs dialogs;


    @Subscribe()
    private void sendEmail() throws Exception{
        Email email= getEditedEntity();

        EmailInfo emailInfo= EmailInfoBuilder.create()
                .setAddresses("m.castellano@golemnet.it, m.castellano@golemnet.it")
                .setSubject(email.getCaption())
                .setFrom(null)
                .setBody(email.getContent()).build();

        emailer.sendEmailAsync(emailInfo);

    }



}