package com.company.appdemo.screen.address;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Address;

@UiController("Address.edit")
@UiDescriptor("address-edit.xml")
@EditedEntityContainer("addressDc")
public class AddressEdit extends StandardEditor<Address> {
}