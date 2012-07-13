package com.pmerienne.eventmonitoring.client.view.mobile;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public interface DashboardView extends IsWidget {

	void setDashboard(Dashboard dashboard);

	void setPresenter(Presenter presenter);

	interface Presenter {

		void goTo(Place place);
	}
}
