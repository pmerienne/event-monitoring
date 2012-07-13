package com.pmerienne.eventmonitoring.client.widget.mobile.list;

import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

public class PieChartList extends BasicList<GraphConfiguration> implements HasCellSelectedHandler {

	public PieChartList() {
		super(new BasicCell<GraphConfiguration>() {
			@Override
			public String getTitleString(GraphConfiguration configuration) {
				String title = configuration.getName();
				return title;
			}

			@Override
			public String getSecondaryString(GraphConfiguration configuration) {
				String series = "";

				int i = 0;
				for (SerieConfiguration serieConfiguration : configuration.getSerieConfigurations()) {
					i++;
					series += serieConfiguration.getName();
					if (i < configuration.getSerieConfigurations().size()) {
						series += ", ";
					}
				}

				if (series.length() > CHAR_LIMIT) {
					series = series.substring(0, CHAR_LIMIT);
				}
				return series;
			}
		});
		this.setHeader("Pie charts");
	}

}