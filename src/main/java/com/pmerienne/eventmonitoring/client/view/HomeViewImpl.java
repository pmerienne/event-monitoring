package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.client.widget.NavigationBar;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class HomeViewImpl extends Composite implements HomeView {

	private static HomeViewUiBinderImpl uiBinder = GWT.create(HomeViewUiBinderImpl.class);

	interface HomeViewUiBinderImpl extends UiBinder<Widget, HomeViewImpl> {
	}

	@UiField
	NavigationBar navigationBar;

	@UiField
	Element restEndPoint;

	public HomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		String endPoint = GWT.getHostPageBaseURL() + "api/events/add";
		this.restEndPoint.setInnerHTML(endPoint);
	}

	@Override
	public void setAvailableDashboards(List<Dashboard> dashboards) {
		this.navigationBar.setAvailableDashboards(dashboards);
	}
}
