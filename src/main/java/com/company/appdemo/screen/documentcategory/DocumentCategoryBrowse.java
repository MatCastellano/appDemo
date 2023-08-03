package com.company.appdemo.screen.documentcategory;

import io.jmix.ui.screen.*;
import com.company.appdemo.entity.DocumentCategory;

@UiController("DocumentCategory.browse")
@UiDescriptor("document-category-browse.xml")
@LookupComponent("documentCategoriesTable")
public class DocumentCategoryBrowse extends StandardLookup<DocumentCategory> {
}