package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.client.widget.NavigationBar;
import com.pmerienne.eventmonitoring.client.widget.editor.DashboardEditor;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class EditDashboardViewImpl extends Composite implements EditDashboardView {

	private static EditDashboardViewImplUiBinder uiBinder = GWT.create(EditDashboardViewImplUiBinder.class);

	interface EditDashboardViewImplUiBinder extends UiBinder<Widget, EditDashboardViewImpl> {
	}

	@UiField
	NavigationBar navigationBar;

	@UiField
	DashboardEditor dashboardEditor;

	private Presenter presenter;

	public EditDashboardViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("saveButton")
	protected void onSaveClicked(ClickEvent event) {
		if (this.dashboardEditor.validate()) {
			Dashboard dashboard = this.dashboardEditor.getValue();
			this.presenter.save(dashboard);
		}
	}

	@Override
	public void setDashboard(Dashboard dashboard) {
		this.dashboardEditor.setValue(dashboard);
	}

	@Override
	public void clear() {
		this.dashboardEditor.clear();
	}

	@Override
	public void setAvailableDashboards(List<Dashboard> dashboards) {
		this.navigationBar.setAvailableDashboards(dashboards);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
