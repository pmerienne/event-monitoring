package com.pmerienne.eventmonitoring.client.activity;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.pmerienne.eventmonitoring.client.ClientFactory;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.view.SearchView;
import com.pmerienne.eventmonitoring.client.widget.table.EventTable.DataProvider;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;

public class SearchActivity extends AbstractActivity implements SearchView.Presenter, DataProvider {

	private ClientFactory clientFactory;

	public SearchActivity(ClientFactory clientFactory) {
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
		Services.getEventService().search(request, new MethodCallback<SearchResults>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				Notifications.error("Search failed : " + caught.getMessage());
			}

			@Override
			public void onSuccess(Method method, SearchResults results) {
				SearchView view = clientFactory.getSearchView();
				view.setResults(results);
				if (results.getEvents().isEmpty()) {
					Notifications.info("No matching event found");
				}
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
