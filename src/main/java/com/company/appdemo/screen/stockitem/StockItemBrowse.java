package com.company.appdemo.screen.stockitem;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.StockItem;

@UiController("StockItem.browse")
@UiDescriptor("stock-item-browse.xml")
@LookupComponent("stockItemsTable")
public class StockItemBrowse extends StandardLookup<StockItem> {
}