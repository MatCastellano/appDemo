package com.company.appdemo.screen.documentcategory;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.DocumentCategory;

@UiController("DocumentCategory.edit")
@UiDescriptor("document-category-edit.xml")
@EditedEntityContainer("documentCategoryDc")
public class DocumentCategoryEdit extends StandardEditor<DocumentCategory> {
}