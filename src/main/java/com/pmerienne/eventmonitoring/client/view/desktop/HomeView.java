package com.pmerienne.eventmonitoring.client.view.desktop;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public interface HomeView extends IsWidget {

	void setAvailableDashboards(List<Dashboard> dashboards);
}
