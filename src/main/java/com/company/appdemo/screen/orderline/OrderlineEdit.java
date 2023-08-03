package com.company.appdemo.screen.orderline;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Orderline;

@UiController("Orderline.edit")
@UiDescriptor("orderline-edit.xml")
@EditedEntityContainer("orderlineDc")
public class OrderlineEdit extends StandardEditor<Orderline> {
}