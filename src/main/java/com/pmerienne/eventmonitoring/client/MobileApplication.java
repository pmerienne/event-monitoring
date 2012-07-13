package com.pmerienne.eventmonitoring.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort.DENSITY;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.pmerienne.eventmonitoring.client.activity.mobile.MobileActivityMapper;
import com.pmerienne.eventmonitoring.client.factory.MobileClientFactory;
import com.pmerienne.eventmonitoring.client.factory.MobileClientFactoryImpl;
import com.pmerienne.eventmonitoring.client.place.mobile.HomePlace;
import com.pmerienne.eventmonitoring.client.place.mobile.MobileAnimationMapper;
import com.pmerienne.eventmonitoring.client.place.mobile.MobilePlaceHistoryMapper;
import com.pmerienne.eventmonitoring.client.theme.ApplicationTheme;

public class MobileApplication implements EntryPoint {

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
		// Init MGWT settings
		MGWTStyle.setTheme(new ApplicationTheme());
		ViewPort viewPort = new MGWTSettings.ViewPort();
		viewPort.setTargetDensity(DENSITY.MEDIUM);
		viewPort.setUserScaleAble(false).setInitialScale(1.0).setMinimumScale(1.0).setMaximumScale(1.0);
		MGWTSettings settings = new MGWTSettings();
		settings.setViewPort(viewPort);
		settings.setPreventScrolling(true);
		settings.setIconUrl("logo.png");
		settings.setAddGlosToIcon(true);
		settings.setFullscreen(true);
		MGWT.applySettings(settings);

		// Create display
		final MobileClientFactory clientFactory = new MobileClientFactoryImpl();
		AnimatableDisplay display = GWT.create(AnimatableDisplay.class);
		RootPanel.get().add(display);

		// Init activity and places mappers
		MobileActivityMapper appActivityMapper = new MobileActivityMapper(clientFactory);
		MobileAnimationMapper appAnimationMapper = new MobileAnimationMapper();
		AnimatingActivityManager activityManager = new AnimatingActivityManager(appActivityMapper, appAnimationMapper, clientFactory.getEventBus());
		activityManager.setDisplay(display);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		MobilePlaceHistoryMapper historyMapper = GWT.create(MobilePlaceHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(clientFactory.getPlaceController(), (EventBus) clientFactory.getEventBus(), new HomePlace());

		historyHandler.handleCurrentHistory();
	}

}
