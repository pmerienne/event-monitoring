package com.pmerienne.eventmonitoring.client.widget.mobile.list;

import com.pmerienne.eventmonitoring.shared.model.Dashboard;

public class DashboardList extends BasicList<Dashboard> {

	public DashboardList() {
		super(new BasicCell<Dashboard>() {
			@Override
			public String getTitleString(Dashboard dashboard) {
				String title = dashboard.getName();
				return title;
			}

			@Override
			public String getSecondaryString(Dashboard dashboard) {
				String description = dashboard.getDescription() == null ? "" : dashboard.getDescription();
				if (description.length() > CHAR_LIMIT) {
					description = description.substring(0, CHAR_LIMIT);
				}
				return description;
			}
		});
	}

}