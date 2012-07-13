package com.pmerienne.eventmonitoring.client.view.mobile;

import java.util.List;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest.SortedField;

public interface EventListView extends IsWidget {

	void setConfigurations(TableConfiguration configuration);

	void setEvents(List<Event> events);

	void clear();

	SortedField getSortedField();

	void setPresenter(Presenter presenter);

	interface Presenter {

		void refresh();

		void goTo(Place place);

		void goBack();
	}
}
