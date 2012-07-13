package com.pmerienne.eventmonitoring.client.view.desktop;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.client.widget.PieChart;
import com.pmerienne.eventmonitoring.client.widget.TimeSeriesGraph;
import com.pmerienne.eventmonitoring.client.widget.desktop.NavigationBar;
import com.pmerienne.eventmonitoring.client.widget.desktop.table.EventTable;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;

public class DashboardViewImpl extends Composite implements DashBoardView {

	private static DashboardViewUiBinder uiBinder = GWT.create(DashboardViewUiBinder.class);

	interface DashboardViewUiBinder extends UiBinder<Widget, DashboardViewImpl> {
	}

	@UiField
	NavigationBar navigationBar;

	@UiField
	HeadingElement dashboardName;

	@UiField
	ParagraphElement dashboardDescription;

	@UiField
	HTMLPanel container;

	private List<TimeSeriesGraph> graphs = new ArrayList<TimeSeriesGraph>();

	private List<PieChart> pieCharts = new ArrayList<PieChart>();

	private List<EventTable> eventTables = new ArrayList<EventTable>();

	@SuppressWarnings("unused")
	private Presenter presenter;

	public DashboardViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void clear() {
		this.dashboardName.setInnerHTML("No dashboard found");
		this.dashboardDescription
				.setInnerHTML("There is no dashboard to display. Select a dashboard in the navigation menu or <a href='#EditDashboardPlace:'>create a new one</a>.");

		this.graphs.clear();
		this.pieCharts.clear();
		this.eventTables.clear();
		this.container.clear();
	}

	@Override
	public void setDashBoard(Dashboard dashBoard) {
		this.dashboardName.setInnerHTML(dashBoard.getName());
		this.dashboardDescription.setInnerHTML(dashBoard.getDescription());

		this.graphs.clear();
		this.pieCharts.clear();
		this.eventTables.clear();
		this.container.clear();

		for (GraphConfiguration graphConfiguration : dashBoard.getGraphConfigurations()) {
			TimeSeriesGraph graph = new TimeSeriesGraph(graphConfiguration);
			this.container.add(graph);
			this.graphs.add(graph);
		}

		for (GraphConfiguration graphConfiguration : dashBoard.getPieConfigurations()) {
			PieChart pieChart = new PieChart(graphConfiguration);
			this.container.add(pieChart);
			this.pieCharts.add(pieChart);
		}

		for (TableConfiguration tableConfiguration : dashBoard.getTableConfigurations()) {
			EventTable eventTable = new EventTable(tableConfiguration);
			this.container.add(eventTable);
			this.eventTables.add(eventTable);
		}

	}

	@Override
	public void setAvailableDashboards(List<Dashboard> dashboards) {
		this.navigationBar.setAvailableDashboards(dashboards);
	}

	@Override
	public List<TimeSeriesGraph> getTimeSeriesGraphs() {
		return graphs;
	}

	@Override
	public List<PieChart> getPieChartGraphs() {
		return this.pieCharts;
	}

	@Override
	public List<EventTable> getEventTables() {
		return eventTables;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
