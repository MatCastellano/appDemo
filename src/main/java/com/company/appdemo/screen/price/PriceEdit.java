package com.company.appdemo.screen.price;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Price;

@UiController("Price.edit")
@UiDescriptor("price-edit.xml")
@EditedEntityContainer("priceDc")
public class PriceEdit extends StandardEditor<Price> {
}