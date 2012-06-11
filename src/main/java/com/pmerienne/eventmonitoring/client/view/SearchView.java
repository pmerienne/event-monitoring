package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.client.widget.table.EventTable.DataProvider;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;

public interface SearchView extends IsWidget {

	void clear();

	void setResults(SearchResults results);

	void setAvailableDashboards(List<Dashboard> dashboards);

	void addDataProvider(DataProvider dataProvider);

	void removeDataProvider(DataProvider dataProvider);

	interface Presenter {
	}
}
