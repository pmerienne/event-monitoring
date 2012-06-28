package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.client.widget.PieChart;
import com.pmerienne.eventmonitoring.client.widget.TimeSeriesGraph;
import com.pmerienne.eventmonitoring.client.widget.table.EventTable;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public interface DashBoardView extends IsWidget {

	void setPresenter(Presenter presenter);

	void clear();

	void setDashBoard(Dashboard dashBoard);

	void setAvailableDashboards(List<Dashboard> dashboards);

	List<TimeSeriesGraph> getTimeSeriesGraphs();

	List<PieChart> getPieChartGraphs();

	List<EventTable> getEventTables();

	public interface Presenter {
	}
}
