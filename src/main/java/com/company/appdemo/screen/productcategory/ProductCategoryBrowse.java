package com.company.appdemo.screen.productcategory;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.ProductCategory;

@UiController("ProductCategory.browse")
@UiDescriptor("product-category-browse.xml")
@LookupComponent("productCategoriesTable")
public class ProductCategoryBrowse extends StandardLookup<ProductCategory> {
}