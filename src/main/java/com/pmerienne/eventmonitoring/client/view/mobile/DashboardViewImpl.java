package com.pmerienne.eventmonitoring.client.view.mobile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.pmerienne.eventmonitoring.client.place.mobile.DashboardListPlace;
import com.pmerienne.eventmonitoring.client.place.mobile.EventListPlace;
import com.pmerienne.eventmonitoring.client.place.mobile.PieChartPlace;
import com.pmerienne.eventmonitoring.client.place.mobile.TimeSeriePlace;
import com.pmerienne.eventmonitoring.client.widget.mobile.list.EventTableList;
import com.pmerienne.eventmonitoring.client.widget.mobile.list.PieChartList;
import com.pmerienne.eventmonitoring.client.widget.mobile.list.TimeSerieList;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;

public class DashboardViewImpl extends Composite implements DashboardView {

	private static DashboardViewImplUiBinder uiBinder = GWT.create(DashboardViewImplUiBinder.class);

	interface DashboardViewImplUiBinder extends UiBinder<Widget, DashboardViewImpl> {
	}

	@UiField
	HeaderButton listButton;

	@UiField
	HTML pageTitle;

	@UiField
	ScrollPanel scrollPanel;

	@UiField
	HTML dashboardDescription;

	@UiField
	TimeSerieList timeSerieList;

	@UiField
	PieChartList pieChartList;

	@UiField
	EventTableList eventTableList;

	private Presenter presenter;

	private Dashboard dashboard;

	public DashboardViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("listButton")
	protected void onListTapped(TapEvent event) {
		this.presenter.goTo(new DashboardListPlace());
	}

	@Override
	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;

		this.pageTitle.setText(dashboard.getName());
		this.dashboardDescription.setText(dashboard.getDescription());

		this.timeSerieList.setVisible(!dashboard.getGraphConfigurations().isEmpty());
		this.timeSerieList.setElements(dashboard.getGraphConfigurations());
		this.pieChartList.setVisible(!dashboard.getPieConfigurations().isEmpty());
		this.pieChartList.setElements(dashboard.getPieConfigurations());
		this.eventTableList.setVisible(!dashboard.getTableConfigurations().isEmpty());
		this.eventTableList.setElements(dashboard.getTableConfigurations());

		this.scrollPanel.refresh();
	}

	@UiHandler("timeSerieList")
	protected void onTimeSerieSelected(CellSelectedEvent event) {
		int index = event.getIndex();
		GraphConfiguration configuration = this.timeSerieList.getElement(index);
		this.presenter.goTo(new TimeSeriePlace(this.dashboard.getId(), this.dashboard.getGraphConfigurations().indexOf(configuration)));
	}

	@UiHandler("pieChartList")
	protected void onPieChartSelected(CellSelectedEvent event) {
		int index = event.getIndex();
		GraphConfiguration configuration = this.pieChartList.getElement(index);
		this.presenter.goTo(new PieChartPlace(this.dashboard.getId(), this.dashboard.getPieConfigurations().indexOf(configuration)));
	}

	@UiHandler("eventTableList")
	protected void onEventListSelected(CellSelectedEvent event) {
		int index = event.getIndex();
		TableConfiguration configuration = this.eventTableList.getElement(index);
		this.presenter.goTo(new EventListPlace(this.dashboard.getId(), this.dashboard.getTableConfigurations().indexOf(configuration)));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
