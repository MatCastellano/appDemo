package com.company.appdemo.screen.orderline;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Orderline;

@UiController("Orderline.browse")
@UiDescriptor("orderline-browse.xml")
@LookupComponent("orderlinesTable")
public class OrderlineBrowse extends StandardLookup<Orderline> {
}