package com.pmerienne.eventmonitoring.client.activity.mobile;

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
import com.pmerienne.eventmonitoring.client.view.mobile.DashboardListView;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class DashboardListActivity extends MobileActivity implements DashboardListView.Presenter {

	public DashboardListActivity(MobileClientFactory clientFactory) {
		super(clientFactory);
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);

		// Refresh view
		DashboardListView view = this.clientFactory.getDashboardListView();
		view.setPresenter(this);
		this.loadAvailableDashboards();
	}

	@Override
	protected IsWidget getView() {
		return this.clientFactory.getDashboardListView();
	}

	@Override
	public void goTo(Place place) {
		this.clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void goBack() {
		History.back();
	}

	private void loadAvailableDashboards() {
		// Show pending
		this.setPending(true);

		Services.getDashboardService().findAll(new MethodCallback<List<Dashboard>>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				// Show notification
				Notifications.error("Unable to load dashboards : " + caught.getMessage());
				setPending(false);
			}

			@Override
			public void onSuccess(Method method, List<Dashboard> dashboards) {
				DashboardListView view = clientFactory.getDashboardListView();
				view.setAvailableDashboards(dashboards);
				setPending(false);
			}
		});
	}
}
