package com.pmerienne.eventmonitoring.client.activity.mobile;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.client.factory.MobileClientFactory;
import com.pmerienne.eventmonitoring.client.place.mobile.DashboardListPlace;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.view.mobile.DashboardView;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class DashboardActivity extends MobileActivity implements DashboardView.Presenter {

	private String dashboardId;

	public DashboardActivity(MobileClientFactory clientFactory, String dashboardId) {
		super(clientFactory);
		this.dashboardId = dashboardId;
	}

	public DashboardActivity(MobileClientFactory clientFactory) {
		super(clientFactory);
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);

		DashboardView view = this.clientFactory.getDashboardView();
		view.setPresenter(this);

		if (this.dashboardId != null && !this.dashboardId.isEmpty()) {
			this.load(this.dashboardId);
		} else {
			this.clientFactory.getPlaceController().goTo(new DashboardListPlace());
		}
	}

	@Override
	protected IsWidget getView() {
		return this.clientFactory.getDashboardView();
	}

	private void load(String dashBoardId) {
		this.setPending(true);

		Services.getDashboardService().find(dashBoardId, new MethodCallback<Dashboard>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				// Show notification
				Notifications.error("Unable to load dashboard : " + caught.getMessage());
				setPending(false);
			}

			@Override
			public void onSuccess(Method method, Dashboard dashBoard) {
				// Update view
				DashboardView view = clientFactory.getDashboardView();
				if (dashBoard == null) {
					clientFactory.getPlaceController().goTo(new DashboardListPlace());
				} else {
					view.setDashboard(dashBoard);
					setPending(false);
				}
			}
		});
	}

	@Override
	public void goTo(Place place) {
		this.clientFactory.getPlaceController().goTo(place);
	}

}
