package com.pmerienne.eventmonitoring.client.activity.mobile;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.pmerienne.eventmonitoring.client.factory.MobileClientFactory;
import com.pmerienne.eventmonitoring.client.view.mobile.HomeView;

public class HomeActivity extends MobileActivity implements HomeView.Presenter {

	public HomeActivity(MobileClientFactory clientFactory) {
		super(clientFactory);
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);

		HomeView homeView = this.clientFactory.getHomeView();
		homeView.setPresenter(this);
	}

	@Override
	protected IsWidget getView() {
		return this.clientFactory.getHomeView();
	}

	@Override
	public void goTo(Place place) {
		this.clientFactory.getPlaceController().goTo(place);
	}

}
