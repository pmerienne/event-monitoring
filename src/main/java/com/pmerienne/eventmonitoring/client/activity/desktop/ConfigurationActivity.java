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
import com.pmerienne.eventmonitoring.client.utils.PopupManager;
import com.pmerienne.eventmonitoring.client.view.desktop.ConfigurationView;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;

public class ConfigurationActivity extends AbstractActivity implements ConfigurationView.Presenter {

	private DesktopClientFactory clientFactory;

	public ConfigurationActivity(DesktopClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		ConfigurationView view = this.clientFactory.getConfigurationView();
		view.setPresenter(this);

		// Load dashboard
		this.loadAvailableDashboards();

		// Load index
		this.loadIndexes();

		// Show view
		panel.setWidget(view);
	}

	@Override
	public void add(final Index index) {
		PopupManager.showPending("Please wait while the index is created");
		Services.getConfigurationService().createIndex(index, new MethodCallback<Void>() {
			@Override
			public void onFailure(Method method, Throwable exception) {
				Notifications.error("Unable to add index on " + index.getKeys() + " : " + exception.getMessage());
				loadIndexes();
				clientFactory.getConfigurationView().clear();
				PopupManager.hidePending();
			}

			@Override
			public void onSuccess(Method method, Void response) {
				Notifications.info("Index on " + index.getKeys() + " created");
				loadIndexes();
				PopupManager.hidePending();
			}
		});
	}

	@Override
	public void delete(final Index index) {
		Services.getConfigurationService().dropIndex(index, new MethodCallback<Void>() {
			@Override
			public void onFailure(Method method, Throwable exception) {
				Notifications.error("Unable to drop index on " + index.getKeys() + " : " + exception.getMessage());
				loadIndexes();
			}

			@Override
			public void onSuccess(Method method, Void response) {
				Notifications.info("Index on " + index.getKeys() + " droped");
				loadIndexes();
			}
		});
	}

	@Override
	public void loadIndexes() {
		Services.getConfigurationService().getIndexes(new MethodCallback<List<Index>>() {
			@Override
			public void onFailure(Method method, Throwable exception) {
				Notifications.error("Unable to load index  : " + exception.getMessage());
			}

			@Override
			public void onSuccess(Method method, List<Index> response) {
				clientFactory.getConfigurationView().setIndexes(response);
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
				ConfigurationView view = clientFactory.getConfigurationView();
				view.setAvailableDashboards(dashboards);
			}
		});
	}
}
