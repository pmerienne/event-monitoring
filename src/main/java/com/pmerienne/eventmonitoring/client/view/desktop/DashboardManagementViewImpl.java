package com.pmerienne.eventmonitoring.client.view.desktop;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.pmerienne.eventmonitoring.client.place.desktop.EditDashboardPlace;
import com.pmerienne.eventmonitoring.client.widget.desktop.NavigationBar;
import com.pmerienne.eventmonitoring.client.widget.desktop.table.DashboardTable;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class DashboardManagementViewImpl extends Composite implements DashboardManagementView {

	private static DashboardManagementViewImplUiBinder uiBinder = GWT.create(DashboardManagementViewImplUiBinder.class);

	interface DashboardManagementViewImplUiBinder extends UiBinder<Widget, DashboardManagementViewImpl> {
	}

	@UiField
	NavigationBar navigationBar;

	@UiField
	DashboardTable dashboardTable;

	@UiField
	Button deleteButton;

	@UiField
	Button editButton;

	private Dashboard selectedDashboard;

	private Presenter presenter;

	public DashboardManagementViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		// Add selection to the table
		final SingleSelectionModel<Dashboard> selectionModel = new SingleSelectionModel<Dashboard>();
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				selectedDashboard = selectionModel.getSelectedObject();
				deleteButton.setVisible(selectedDashboard != null);
				editButton.setVisible(selectedDashboard != null);
			}
		});
		this.dashboardTable.setSelectionModel(selectionModel);
	}

	@UiHandler("deleteButton")
	protected void onDeleteClicked(ClickEvent event) {
		if (this.selectedDashboard != null) {
			this.presenter.delete(this.selectedDashboard);
		}
	}

	@UiHandler("editButton")
	protected void onEditClicked(ClickEvent event) {
		if (this.selectedDashboard != null) {
			this.presenter.goTo(new EditDashboardPlace(this.selectedDashboard.getId()));
		}
	}

	@UiHandler("createNewButton")
	protected void onCreateNewClicked(ClickEvent event) {
		this.presenter.goTo(new EditDashboardPlace());
	}

	@Override
	public void setAvailableDashboards(List<Dashboard> dashboards) {
		this.dashboardTable.setRowData(dashboards);
		this.navigationBar.setAvailableDashboards(dashboards);

		// Clear selection
		selectedDashboard = null;
		this.deleteButton.setVisible(false);
		this.editButton.setVisible(false);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
