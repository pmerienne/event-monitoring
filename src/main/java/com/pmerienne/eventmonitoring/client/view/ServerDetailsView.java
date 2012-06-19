package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.client.widget.TimeSeriesGraph;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.administration.DatabaseInformation;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;

public interface ServerDetailsView extends IsWidget {

	void setAvailableDashboards(List<Dashboard> dashboards);

	void setDatabaseInformation(DatabaseInformation databaseInformation);

	void clear();

	TimeSeriesGraph initLastEventsGraph(GraphConfiguration graphConfiguration);
}
