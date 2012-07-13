package com.pmerienne.eventmonitoring.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.pmerienne.eventmonitoring.client.activity.desktop.DesktopActivityMapper;
import com.pmerienne.eventmonitoring.client.factory.DesktopClientFactory;
import com.pmerienne.eventmonitoring.client.factory.DesktopClientFactoryImpl;
import com.pmerienne.eventmonitoring.client.place.desktop.DesktopPlaceHistoryMapper;
import com.pmerienne.eventmonitoring.client.place.desktop.HomePlace;

public class DesktopApplication implements EntryPoint {

	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void onUncaughtException(Throwable e) {
				// Window.alert("uncaught: " + e.getMessage());
				e.printStackTrace();
			}
		});

		new Timer() {
			@Override
			public void run() {
				createApplication();
			}

		}.schedule(1);

	}

	private void createApplication() {
		// Init display
		SimplePanel appWidget = new SimplePanel();
		RootPanel.get().add(appWidget);
		Place defaultPlace = new HomePlace();

		// Init client factory
		DesktopClientFactory clientFactory = new DesktopClientFactoryImpl();
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new DesktopActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		DesktopPlaceHistoryMapper historyMapper = GWT.create(DesktopPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootPanel.get().add(appWidget);

		// Goes to the place represented on URL else default place
		historyHandler.handleCurrentHistory();
	}

}
