package com.pmerienne.eventmonitoring.client.activity;

import java.util.Date;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.user.client.Timer;
import com.pmerienne.eventmonitoring.client.service.Services;
import com.pmerienne.eventmonitoring.client.utils.Notifications;
import com.pmerienne.eventmonitoring.client.utils.TimeDataFetcher;
import com.pmerienne.eventmonitoring.client.widget.TimeSeriesGraph;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieRequest;
import com.pmerienne.eventmonitoring.shared.model.request.TimeSerieResults;

public class SerieSearcherTimer extends Timer {

	private TimeSeriesGraph graph;

	private SerieConfiguration serieConfiguration;

	private Date lastUpdate;

	public SerieSearcherTimer(TimeSeriesGraph graph, SerieConfiguration serieConfiguration) {
		super();
		this.graph = graph;
		this.serieConfiguration = serieConfiguration;
		this.lastUpdate = new Date(new Date().getTime() - graph.getGraphConfiguration().getTimeRange());
	}

	@Override
	public void run() {
		final Date from = this.lastUpdate;
		final Date to = new Date();
		this.lastUpdate = to;
		graph.showLoading("Loading data ...");

		Services.getEventService().search(new TimeSerieRequest(serieConfiguration, from, to), new MethodCallback<TimeSerieResults>() {
			@Override
			public void onFailure(Method method, Throwable caught) {
				String graphName = graph.getGraphConfiguration().getName();
				String serieName = serieConfiguration.getName();
				Notifications.error("Unable to load data for " + graphName + ":" + serieName + ". Cause : " + caught.getMessage());
				graph.hideLoading();
			}

			@Override
			public void onSuccess(Method method, TimeSerieResults result) {
				graph.addData(serieConfiguration.getName(), TimeDataFetcher.fetchDatas(result));
				graph.hideLoading();
			}
		});
	}
}