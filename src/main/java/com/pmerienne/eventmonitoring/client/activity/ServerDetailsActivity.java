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
import com.pmerienne.eventmonitoring.client.view.ServerDetailsView;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.administration.DatabaseInformation;

public class ServerDetailsActivity extends AbstractActivity {

	private ClientFactory clientFactory;

	public ServerDetailsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		ServerDetailsView view = this.clientFactory.getServerDetailsView();
		this.loadAvailableDashboards();
		this.loadServerDetails();
		panel.setWidget(view);
	}

	private void loadServerDetails() {
		Services.getConfigurationService().getServerDetails(new MethodCallback<DatabaseInformation>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				// Show notification
				Notifications.error("Unable to load server details : " + caught.getMessage());
			}

			@Override
			public void onSuccess(Method method, DatabaseInformation databaseInformation) {
				ServerDetailsView view = clientFactory.getServerDetailsView();
				view.setDatabaseInformation(databaseInformation);
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
				ServerDetailsView view = clientFactory.getServerDetailsView();
				view.setAvailableDashboards(dashboards);
			}
		});
	}
}