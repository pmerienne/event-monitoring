package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;

public interface ConfigurationView extends IsWidget {

	void setIndexes(List<Index> indexes);

	void setAvailableDashboards(List<Dashboard> dashboards);

	void setPresenter(Presenter presenter);

	void clear();

	public interface Presenter {

		void add(Index index);

		void delete(Index index);

		void loadIndexes();
	}
}
