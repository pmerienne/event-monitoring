package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SingleSelectionModel;
import com.pmerienne.eventmonitoring.client.utils.PopupManager;
import com.pmerienne.eventmonitoring.client.widget.NavigationBar;
import com.pmerienne.eventmonitoring.client.widget.editor.IndexEditor;
import com.pmerienne.eventmonitoring.client.widget.popup.ConfirmPopupCallback;
import com.pmerienne.eventmonitoring.client.widget.table.IndexTable;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;

public class ConfigurationViewImpl extends Composite implements ConfigurationView {

	private static ConfigurationViewImplUiBinder uiBinder = GWT.create(ConfigurationViewImplUiBinder.class);

	interface ConfigurationViewImplUiBinder extends UiBinder<Widget, ConfigurationViewImpl> {
	}

	@UiField
	NavigationBar navigationBar;

	@UiField
	IndexTable indexTable;

	private SingleSelectionModel<Index> indexSelectionModel;

	private Presenter presenter;

	public ConfigurationViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		this.indexSelectionModel = new SingleSelectionModel<Index>();
		this.indexTable.setSelectionModel(this.indexSelectionModel);
	}

	@UiHandler("createButton")
	protected void onCreateClicked(ClickEvent event) {
		final IndexEditor editor = new IndexEditor();
		PopupManager.show("New index", editor, new ConfirmPopupCallback() {
			@Override
			public boolean onOk() {
				boolean isValid = editor.validate();
				if (isValid) {
					Index index = editor.getValue();
					presenter.add(index);
				}
				return isValid;
			}

			@Override
			public void onCancel() {
			}
		});
	}

	@UiHandler("deleteButton")
	protected void onDeleteClicked(ClickEvent event) {
		Index index = this.indexSelectionModel.getSelectedObject();
		if (index != null) {
			this.presenter.delete(index);
		}
	}

	@Override
	public void clear() {
	}

	@Override
	public void setIndexes(List<Index> indexes) {
		this.indexTable.setRowData(indexes);
	}

	@Override
	public void setAvailableDashboards(List<Dashboard> dashboards) {
		navigationBar.setAvailableDashboards(dashboards);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
