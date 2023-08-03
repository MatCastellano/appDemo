package com.company.appdemo.entity.customer;

import io.jmix.core.FileRef;
import io.jmix.core.SaveContext;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.*;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.data.ValueSource;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.navigation.UrlParamsChangedEvent;
import io.jmix.ui.screen.*;
import com.company.appdemo.entity.Customer;
import io.jmix.ui.settings.facet.ScreenSettingsFacet;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.io.InputStream;
import java.util.Set;

@UiController("Customer_import.edit")
@UiDescriptor("customer_import-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerImportEdit extends Screen{
    @Subscribe
    public void onBeforeClose(BeforeCloseEvent event) {
        
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

    }

    @Subscribe
    public void onUrlParamsChanged(UrlParamsChangedEvent event) {

    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {

    }

    @Subscribe
    public void onAfterClose(AfterCloseEvent event) {

    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {

    }

    @Subscribe
    public void onInit(InitEvent event) {

    }

    @Subscribe
    public void onAfterDetach(AfterDetachEvent event) {

    }

    @Subscribe("closeBtn")
    public void onCloseBtnClick(Button.ClickEvent event) {

    }

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {

    }

    @Subscribe("documentField")
    public void onDocumentFieldBeforeValueClear(SingleFileUploadField.BeforeValueClearEvent event) {

    }

    @Subscribe("documentField")
    public void onDocumentFieldFileUploadError(UploadField.FileUploadErrorEvent event) {

    }

    @Subscribe("documentField")
    public void onDocumentFieldFileUploadStart(UploadField.FileUploadStartEvent event) {

    }

    @Subscribe("documentField")
    public void onDocumentFieldFileUploadFinish(UploadField.FileUploadFinishEvent event) {

    }

    @Subscribe("documentField")
    public void onDocumentFieldFileUploadSucceed(SingleFileUploadField.FileUploadSucceedEvent event) {

    }

    @Subscribe("documentField")
    public void onDocumentFieldAfterValueClear(SingleFileUploadField.AfterValueClearEvent event) {

    }

    @Subscribe("documentField")
    public void onDocumentFieldValueChange(HasValue.ValueChangeEvent<FileRef> event) {

    }

    @Install(to = "documentField", subject = "contentProvider")
    private InputStream documentFieldContentProvider() {
        return null;
    }

    @Install(to = "documentField", subject = "contextHelpIconClickHandler")
    private void documentFieldContextHelpIconClickHandler(HasContextHelp.ContextHelpIconClickEvent contextHelpIconClickEvent) {

    }

    @Install(to = "documentField", subject = "validator")
    private void documentFieldValidator(FileRef value) {

    }

    @Subscribe("editActions")
    public void onEditActionsLayoutClick(LayoutClickNotifier.LayoutClickEvent event) {

    }

    @Install(to = "editActions", subject = "contextHelpIconClickHandler")
    private void editActionsContextHelpIconClickHandler(HasContextHelp.ContextHelpIconClickEvent contextHelpIconClickEvent) {

    }

    @Subscribe("form")
    public void onFormEditableChange(EditableChangeNotifier.EditableChangeEvent event) {

    }

    @Install(to = "form", subject = "contextHelpIconClickHandler")
    private void formContextHelpIconClickHandler(HasContextHelp.ContextHelpIconClickEvent contextHelpIconClickEvent) {

    }

    @Install(to = "form", subject = "valueSourceProvider")
    private ValueSource<?> formValueSourceProvider(String property) {
        return null;
    }

    @Subscribe("windowClose")
    public void onWindowClose(Action.ActionPerformedEvent event) {

    }

    @Install(to = "windowClose", subject = "enabledRule")
    private boolean windowCloseEnabledRule() {
        return false;
    }

    @Subscribe("windowCommitAndClose")
    public void onWindowCommitAndClose(Action.ActionPerformedEvent event) {

    }

    @Install(to = "windowCommitAndClose", subject = "enabledRule")
    private boolean windowCommitAndCloseEnabledRule() {
        return false;
    }

    @Install(to = "settingsFacet", subject = "applyDataLoadingSettingsDelegate")
    private void settingsFacetApplyDataLoadingSettingsDelegate(ScreenSettingsFacet.SettingsContext settingsContext) {

    }

    @Install(to = "settingsFacet", subject = "saveSettingsDelegate")
    private void settingsFacetSaveSettingsDelegate(ScreenSettingsFacet.SettingsContext settingsContext) {

    }

    @Install(to = "settingsFacet", subject = "applySettingsDelegate")
    private void settingsFacetApplySettingsDelegate(ScreenSettingsFacet.SettingsContext settingsContext) {

    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPreCommit(DataContext.PreCommitEvent event) {

    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onChange(DataContext.ChangeEvent event) {

    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPostCommit(DataContext.PostCommitEvent event) {

    }

    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> commitDelegate(SaveContext saveContext) {
        return null;
    }

    @Subscribe(id = "customerDc", target = Target.DATA_CONTAINER)
    public void onCustomerDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Customer> event) {

    }

    @Subscribe(id = "customerDc", target = Target.DATA_CONTAINER)
    public void onCustomerDcItemChange(InstanceContainer.ItemChangeEvent<Customer> event) {

    }

}