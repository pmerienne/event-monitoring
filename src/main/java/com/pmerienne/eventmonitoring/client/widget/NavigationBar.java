package com.pmerienne.eventmonitoring.client.widget;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class NavigationBar extends Composite {

	private static NavigationBarUiBinder uiBinder = GWT.create(NavigationBarUiBinder.class);

	interface NavigationBarUiBinder extends UiBinder<Widget, NavigationBar> {
	}

	@UiField
	UListElement dashboardsDropDown;

	public NavigationBar() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setAvailableDashboards(List<Dashboard> dashboards) {
		this.clearDashboards();

		for (Dashboard dashboard : dashboards) {
			LIElement li = Document.get().createLIElement();
			AnchorElement anchor = Document.get().createAnchorElement();
			anchor.setInnerHTML(dashboard.getName());
			anchor.setHref("#DashboardPlace:" + dashboard.getId());
			li.appendChild(anchor);
			this.dashboardsDropDown.appendChild(li);
		}
	}

	private void clearDashboards() {
		// Remove all existing child nodes.
		Node child = this.dashboardsDropDown.getFirstChild();
		while (child != null) {
			this.dashboardsDropDown.removeChild(child);
			child = this.dashboardsDropDown.getFirstChild();
		}
	}
}
