package com.pmerienne.eventmonitoring.client.view.mobile;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.pmerienne.eventmonitoring.client.place.mobile.HomePlace;
import com.pmerienne.eventmonitoring.client.place.mobile.DashboardPlace;
import com.pmerienne.eventmonitoring.client.widget.mobile.list.DashboardList;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class DashboardListViewImpl extends Composite implements DashboardListView {

	private static DashboardListViewImplUiBinder uiBinder = GWT.create(DashboardListViewImplUiBinder.class);

	interface DashboardListViewImplUiBinder extends UiBinder<Widget, DashboardListViewImpl> {
	}

	@UiField
	HeaderButton homeButton;

	@UiField
	DashboardList dashboardList;

	private Presenter presenter;

	public DashboardListViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("homeButton")
	protected void onBackTaped(TapEvent event) {
		this.presenter.goTo(new HomePlace());
	}

	@UiHandler("dashboardList")
	protected void onDashboardSelected(CellSelectedEvent event) {
		int index = event.getIndex();
		Dashboard dashboard = this.dashboardList.getElement(index);
		this.presenter.goTo(new DashboardPlace(dashboard.getId()));
	}

	@Override
	public void setAvailableDashboards(List<Dashboard> dashboards) {
		this.dashboardList.setElements(dashboards);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
