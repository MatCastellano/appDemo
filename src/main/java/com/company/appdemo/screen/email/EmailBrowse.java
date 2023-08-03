package com.company.appdemo.screen.email;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Email;

@UiController("Email.browse")
@UiDescriptor("email-browse.xml")
@LookupComponent("emailsTable")
public class EmailBrowse extends StandardLookup<Email> {



}