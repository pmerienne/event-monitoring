package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public interface DashboardManagementView extends IsWidget {

	void setAvailableDashboards(List<Dashboard> dashboards);

	void setPresenter(Presenter presenter);

	interface Presenter {

		void delete(Dashboard dashboard);

		void goTo(Place place);
	}
}
