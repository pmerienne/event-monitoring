package com.pmerienne.eventmonitoring.client.activity.desktop;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.pmerienne.eventmonitoring.client.factory.DesktopClientFactory;
import com.pmerienne.eventmonitoring.client.place.desktop.DashboardPlace;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.utils.PopupManager;
import com.pmerienne.eventmonitoring.client.view.desktop.EditDashboardView;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class EditDashboardActivity extends AbstractActivity implements EditDashboardView.Presenter {

	private DesktopClientFactory clientFactory;

	private String dashboardId;

	public EditDashboardActivity(DesktopClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public EditDashboardActivity(DesktopClientFactory clientFactory, String dashboardId) {
		super();
		this.clientFactory = clientFactory;
		this.dashboardId = dashboardId;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		EditDashboardView view = this.clientFactory.getEditDashboardView();
		view.setPresenter(this);

		// Load dashboards
		this.loadAvailableDashboards();

		if (this.dashboardId == null || this.dashboardId.isEmpty()) {
			view.setDashboard(new Dashboard());
		} else {
			this.loadDashboard(this.dashboardId);
		}

		// Add view
		panel.setWidget(view);
	}

	private void loadDashboard(String dashboardId) {
		PopupManager.showPending("Loading dashboard");
		Services.getDashboardService().find(dashboardId, new MethodCallback<Dashboard>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				PopupManager.hidePending();
				// Show notification
				Notifications.error("Unable to load dashboard : " + caught.getMessage());
			}

			@Override
			public void onSuccess(Method method, Dashboard dashboard) {
				EditDashboardView view = clientFactory.getEditDashboardView();
				if (dashboard != null) {
					view.setDashboard(dashboard);
				} else {
					view.clear();
				}
				PopupManager.hidePending();
			}
		});
	}

	@Override
	public void save(Dashboard dashboard) {
		Services.getDashboardService().save(dashboard, new MethodCallback<Dashboard>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				// Show notification
				Notifications.error("Unable to save dashboard : " + caught.getMessage());
			}

			@Override
			public void onSuccess(Method method, Dashboard result) {
				// Show notification
				Notifications.info("Dashboard " + result.getName() + " saved");

				// View dashboard
				clientFactory.getPlaceController().goTo(new DashboardPlace(result.getId()));
			}
		});
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
				EditDashboardView view = clientFactory.getEditDashboardView();
				view.setAvailableDashboards(dashboards);
			}
		});
	}
}
