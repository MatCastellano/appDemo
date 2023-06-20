package com.company.appdemo.screen.stockitem;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.StockItem;

@UiController("StockItem.edit")
@UiDescriptor("stock-item-edit.xml")
@EditedEntityContainer("stockItemDc")
public class StockItemEdit extends StandardEditor<StockItem> {
}