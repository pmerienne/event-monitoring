package com.pmerienne.eventmonitoring.client.activity.desktop;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.pmerienne.eventmonitoring.client.factory.DesktopClientFactory;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.view.desktop.SearchView;
import com.pmerienne.eventmonitoring.client.widget.desktop.table.EventTable.DataProvider;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;

public class SearchActivity extends AbstractActivity implements SearchView.Presenter, DataProvider {

	private DesktopClientFactory clientFactory;

	public SearchActivity(DesktopClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		SearchView view = this.clientFactory.getSearchView();
		view.clear();
		view.addDataProvider(this);
		this.loadAvailableDashboards();
		panel.setWidget(view);
	}

	private void loadAvailableDashboards() {
		Services.getDashboardService().findAll(new MethodCallback<List<Dashboard>>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				// Show notification
				Notifications.error("Unable to load dashboards : " + caught.getMessage());
			}

			@Override
			public void onSuccess(Method method, List<Dashboard> dashboards) {
				SearchView view = clientFactory.getSearchView();
				view.setAvailableDashboards(dashboards);
			}
		});
	}

	@Override
	public void onRequestChange(SearchRequest request) {
		final SearchView view = clientFactory.getSearchView();
		view.setPending(true);
		
		Services.getEventService().search(request, new MethodCallback<SearchResults>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				Notifications.error("Search failed : " + caught.getMessage());
				view.setPending(false);
			}

			@Override
			public void onSuccess(Method method, SearchResults results) {
				view.setResults(results);
				view.setPending(false);
			}
		});
	}

	@Override
	public void onCancel() {
		super.onCancel();
		SearchView view = this.clientFactory.getSearchView();
		view.removeDataProvider(this);
	}

	@Override
	public void onStop() {
		super.onStop();
		SearchView view = this.clientFactory.getSearchView();
		view.removeDataProvider(this);
	}
}
