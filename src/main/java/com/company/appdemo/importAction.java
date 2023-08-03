package com.company.appdemo;


import com.company.appdemo.entity.Customer;
import com.company.appdemo.screen.customer.CustomerEdit;
import io.jmix.core.*;
import io.jmix.ui.Screens;
import io.jmix.ui.action.ActionType;
import io.jmix.ui.action.ItemTrackingAction;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Collection;

@ActionType("import")
public class importAction extends ItemTrackingAction {


    public importAction() throws IOException {
    }

    public importAction(String id) throws IOException {
        super();
    }


    @Autowired
    private Screens screen;

    /*@Subscribe("uploadButton")
    private void showImportScreen(){
        screen.create(CustomerEdit.class).show();
    }
*/

}
