package com.company.appdemo.screen.product;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Product;

@UiController("Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
public class ProductBrowse extends StandardLookup<Product> {
}