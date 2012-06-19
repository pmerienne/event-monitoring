package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.administration.DatabaseInformation;

public interface ServerDetailsView extends IsWidget {

	void setAvailableDashboards(List<Dashboard> dashboards);

	void setDatabaseInformation(DatabaseInformation databaseInformation);
}
