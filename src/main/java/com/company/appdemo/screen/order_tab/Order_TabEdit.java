package com.company.appdemo.screen.order_tab;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Order_Tab;

@UiController("ORDER_TAB.edit")
@UiDescriptor("order_tab-edit.xml")
@EditedEntityContainer("order_TabDc")
public class Order_TabEdit extends StandardEditor<Order_Tab> {
}