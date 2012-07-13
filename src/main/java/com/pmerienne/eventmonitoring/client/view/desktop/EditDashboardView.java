package com.pmerienne.eventmonitoring.client.view.desktop;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public interface EditDashboardView extends IsWidget {

	void setDashboard(Dashboard dashboard);

	void setAvailableDashboards(List<Dashboard> dashboards);

	void clear();

	void setPresenter(Presenter presenter);

	interface Presenter {

		void save(Dashboard dashboard);
	}
}
