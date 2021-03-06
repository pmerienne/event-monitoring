package com.pmerienne.eventmonitoring.client.view.desktop;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.client.widget.desktop.table.EventTable.DataProvider;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;

public interface SearchView extends IsWidget {

	void clear();

	void setResults(SearchResults results);

	void setAvailableDashboards(List<Dashboard> dashboards);

	void addDataProvider(DataProvider dataProvider);

	void removeDataProvider(DataProvider dataProvider);
	
	void setPending(boolean pending);

	interface Presenter {
	}
}
