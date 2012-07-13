package com.pmerienne.eventmonitoring.client.view.mobile;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.client.widget.PieChart;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;

public interface PieChartView extends IsWidget {

	void clear();

	PieChart setPieChartConfiguration(GraphConfiguration configuration);

	void setPresenter(Presenter presenter);

	interface Presenter {

		void goTo(Place place);

		void goBack();
	}

}
