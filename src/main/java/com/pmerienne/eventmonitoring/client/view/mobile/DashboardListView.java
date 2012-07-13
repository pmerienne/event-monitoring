package com.pmerienne.eventmonitoring.client.view.mobile;

import java.util.List;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public interface DashboardListView extends IsWidget {

	void setAvailableDashboards(List<Dashboard> dashboards);

	void setPresenter(Presenter presenter);

	interface Presenter {

		void goTo(Place place);

		void goBack();
	}
}
