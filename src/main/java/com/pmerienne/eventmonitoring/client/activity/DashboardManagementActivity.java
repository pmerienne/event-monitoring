package com.pmerienne.eventmonitoring.client.activity;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.pmerienne.eventmonitoring.client.ClientFactory;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.view.DashboardManagementView;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class DashboardManagementActivity extends AbstractActivity implements DashboardManagementView.Presenter {

	private ClientFactory clientFactory;

	public DashboardManagementActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		DashboardManagementView view = this.clientFactory.getDashboardManagementView();
		view.setPresenter(this);

		// Load available dashboards
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
				DashboardManagementView view = clientFactory.getDashboardManagementView();
				view.setAvailableDashboards(dashboards);
			}
		});
	}

	@Override
	public void delete(Dashboard dashboard) {
		Services.getDashboardService().delete(dashboard, new MethodCallback<Void>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				Notifications.error("Unable to delete dashboard : " + caught.getMessage());

			}

			@Override
			public void onSuccess(Method method, Void result) {
				Notifications.info("Dashboard deleted");
				loadAvailableDashboards();
			}
		});
	}

	@Override
	public void goTo(Place place) {
		this.clientFactory.getPlaceController().goTo(place);
	}
}
