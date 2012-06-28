package com.pmerienne.eventmonitoring.client.widget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Point;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.Series.Type;

import com.pmerienne.eventmonitoring.shared.model.PieData;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

public class PieChart extends Chart {

	private GraphConfiguration graphConfiguration;

	private Map<String, Double> data = new HashMap<String, Double>();

	private Map<String, SerieConfiguration> serieConfigurations = new HashMap<String, SerieConfiguration>();

	public PieChart() {
		super();
		this.setType(Type.PIE);
	}

	public PieChart(GraphConfiguration graphConfiguration) {
		this();
		this.setGraphConfiguration(graphConfiguration);
	}

	public void addData(List<PieData> chartDatas) {
		for (PieData chartData : chartDatas) {
			this.data.put(chartData.getSerieName(), chartData.getValue());
		}
		this.updatePoints();
	}

	public void addData(PieData chartData) {
		this.data.put(chartData.getSerieName(), chartData.getValue());
		this.updatePoints();
	}

	private void updatePoints() {
		// Remove actual series
		this.removeAllSeries();

		// Create a new series
		Series series = this.createSeries();

		// Fill series with data
		for (Entry<String, Double> data : this.data.entrySet()) {
			Point point = this.toPoint(data.getKey(), data.getValue());
			series.addPoint(point, false, false, false);
		}

		// Set series
		this.addSeries(series, true, false);
	}

	private Point toPoint(String serieName, Double value) {
		Point point = new Point(serieName, value);
		if (this.serieConfigurations.containsKey(serieName)) {
			SerieConfiguration serieConfiguration = this.serieConfigurations.get(serieName);
			if (serieConfiguration.getColor() != null && !serieConfiguration.getColor().isEmpty()) {
				point.setColor(serieConfiguration.getColor());
			}
		}
		return point;
	}

	@Override
	public Series createSeries() {
		return super.createSeries().setType(Type.PIE);
	}

	public GraphConfiguration getGraphConfiguration() {
		return graphConfiguration;
	}

	public void setGraphConfiguration(GraphConfiguration graphConfiguration) {
		this.graphConfiguration = graphConfiguration;
		this.setChartTitleText(graphConfiguration.getName());

		for (SerieConfiguration serieConfiguration : graphConfiguration.getSerieConfigurations()) {
			this.serieConfigurations.put(serieConfiguration.getName(), serieConfiguration);
		}
		this.redraw();
	}
}
