package com.pmerienne.eventmonitoring.client.activity.mobile;

import java.util.Arrays;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.client.factory.MobileClientFactory;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.view.mobile.EventListView;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest.SortedField;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;

public class EventListActivity extends MobileActivity implements EventListView.Presenter {

	private String dashboardId;

	private Integer configurationIndex;

	private TableConfiguration configuration;

	public EventListActivity(MobileClientFactory clientFactory, String dashboardId, Integer configurationIndex) {
		super(clientFactory);
		this.dashboardId = dashboardId;
		this.configurationIndex = configurationIndex;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);

		EventListView view = this.clientFactory.getEventListView();
		view.setPresenter(this);

		this.loadTableConfiguration();
	}

	private void loadTableConfiguration() {
		final EventListView view = this.clientFactory.getEventListView();
		this.setPending(true);

		Services.getDashboardService().find(this.dashboardId, new MethodCallback<Dashboard>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				// Show notification
				Notifications.error("Unable to load dashboard : " + caught.getMessage());
				setPending(false);
			}

			@Override
			public void onSuccess(Method method, Dashboard dashBoard) {
				setPending(false);
				if (dashBoard == null) {
					clear();
				} else {
					configuration = dashBoard.getTableConfigurations().get(configurationIndex);
					view.setConfigurations(configuration);
					loadEvents(null);
				}
			}
		});
	}

	private void loadEvents(SortedField sortedField) {
		if (this.configuration != null) {
			this.setPending(true);

			List<SortedField> sortedFields = sortedField == null ? null : Arrays.asList(sortedField);
			SearchRequest request = new SearchRequest(this.configuration, 0, this.configuration.getNbResults(), sortedFields);

			Services.getEventService().search(request, new MethodCallback<SearchResults>() {
				@Override
				public void onFailure(Method method, Throwable caught) {
					setPending(false);
					Notifications.error("Search failed : " + caught.getMessage());
				}

				@Override
				public void onSuccess(Method method, SearchResults result) {
					setPending(false);
					EventListView view = clientFactory.getEventListView();
					view.setEvents(result.getEvents());
				}
			});
		}
	}

	@Override
	public void refresh() {
		EventListView view = this.clientFactory.getEventListView();
		SortedField sortedField = view.getSortedField();
		this.loadEvents(sortedField);
	}

	@Override
	public void onCancel() {
		this.clear();
	}

	@Override
	public void onStop() {
		this.clear();
	}

	private void clear() {
		EventListView view = this.clientFactory.getEventListView();
		view.clear();
	}

	@Override
	public void goTo(Place place) {
		this.clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void goBack() {
		History.back();
	}

	@Override
	protected IsWidget getView() {
		return this.clientFactory.getEventListView();
	}

}
