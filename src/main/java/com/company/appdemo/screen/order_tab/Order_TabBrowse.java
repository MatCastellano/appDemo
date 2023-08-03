package com.company.appdemo.screen.order_tab;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Order_Tab;

@UiController("ORDER_TAB.browse")
@UiDescriptor("order_tab-browse.xml")
@LookupComponent("order_TabsTable")
public class Order_TabBrowse extends StandardLookup<Order_Tab> {
}