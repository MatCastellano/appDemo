package com.company.appdemo.screen.productcategory;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.ProductCategory;

@UiController("ProductCategory.edit")
@UiDescriptor("product-category-edit.xml")
@EditedEntityContainer("productCategoryDc")
public class ProductCategoryEdit extends StandardEditor<ProductCategory> {
}