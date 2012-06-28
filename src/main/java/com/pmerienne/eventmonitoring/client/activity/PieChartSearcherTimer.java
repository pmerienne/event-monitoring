package com.pmerienne.eventmonitoring.client.activity;

import java.util.Date;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.user.client.Timer;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.widget.PieChart;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.PieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.PieResults;

public class PieChartSearcherTimer extends Timer {

	private PieChart chart;

	private SerieConfiguration serieConfiguration;

	private Date lastUpdate;

	public PieChartSearcherTimer(PieChart chart, SerieConfiguration serieConfiguration) {
		super();
		this.chart = chart;
		this.serieConfiguration = serieConfiguration;
		this.lastUpdate = new Date(new Date().getTime() - serieConfiguration.getInterval());
	}

	@Override
	public void run() {
		final Date from = this.lastUpdate;
		final Date to = new Date();
		this.lastUpdate = to;
		this.chart.showLoading("Loading data ...");

		Services.getEventService().search(new PieRequest(this.serieConfiguration, from, to), new MethodCallback<PieResults>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				String graphName = chart.getGraphConfiguration().getName();
				String serieName = serieConfiguration.getName();
				Notifications.error("Unable to load data for " + graphName + ":" + serieName + ". Cause : " + caught.getMessage());
				chart.hideLoading();
			}

			@Override
			public void onSuccess(Method method, PieResults results) {
				chart.addData(results.getData());
				chart.hideLoading();
			}
		});
	}
}