package com.pmerienne.eventmonitoring.client.widget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.moxieapps.gwt.highcharts.client.Axis;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Point;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.plotOptions.AreaPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.AreaSplinePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.BarPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.ColumnPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.LinePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.ScatterPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SplinePlotOptions;

import com.pmerienne.eventmonitoring.shared.model.TimeData;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.SerieConfiguration;

public class TimeSeriesGraph extends Chart {

	private Map<String, Series> displayedSeries = new HashMap<String, Series>();

	private Map<String, SerieConfiguration> seriesConfigurations = new HashMap<String, SerieConfiguration>();

	private GraphConfiguration graphConfiguration;

	@Deprecated
	public TimeSeriesGraph() {
		super();
		this.getXAxis().setType(Axis.Type.DATE_TIME);
	}

	public TimeSeriesGraph(GraphConfiguration graphConfiguration) {
		super();
		this.setGraphConfiguration(graphConfiguration);
		for (SerieConfiguration serieConfiguration : graphConfiguration.getSerieConfigurations()) {
			Series series = this.createSeries(serieConfiguration);
			this.addSeries(series);
			this.displayedSeries.put(serieConfiguration.getName(), series);
			this.seriesConfigurations.put(serieConfiguration.getName(), serieConfiguration);
		}
	}

	public void addData(String serieName, List<TimeData> data) {

		// Get points
		Point[] points = this.toPoints(data);

		if (!this.displayedSeries.containsKey(serieName)) {
			// If the series doesn't exist we create it
			Series series = this.createSeries().setName(serieName).setPoints(points);
			this.addSeries(series);
			this.displayedSeries.put(serieName, series);
		} else {
			// If the series exists we add point to it
			for (Point point : points) {
				// Get series
				Series series = this.displayedSeries.get(serieName);

				// Shift current points if they exists
				boolean shift = this.mustShift(serieName);

				// Add points
				series.addPoint(point, true, shift, false);
			}
		}

	}

	private boolean mustShift(String serieName) {
		Series series = this.displayedSeries.get(serieName);
		SerieConfiguration serieConfiguration = this.seriesConfigurations.get(serieName);

		Long seriesLength = Long.valueOf(series.getPoints().length);
		Long interval = serieConfiguration.getInterval();
		Long timeRange = this.graphConfiguration.getTimeRange();
		Long maxLength = timeRange / interval;

		return seriesLength >= maxLength;
	}

	private Point[] toPoints(List<TimeData> timeDatas) {
		Point[] points = new Point[timeDatas.size()];
		int i = 0;
		for (TimeData timeData : timeDatas) {
			points[i] = new Point(timeData.getDate().getTime(), timeData.getValue());
			i++;
		}
		return points;
	}

	public GraphConfiguration getGraphConfiguration() {
		return graphConfiguration;
	}

	public void setGraphConfiguration(GraphConfiguration graphConfiguration) {
		this.graphConfiguration = graphConfiguration;
		this.getXAxis().setType(Axis.Type.DATE_TIME);
		this.setChartTitleText(graphConfiguration.getName());
		this.redraw();
	}

	public Series createSeries(SerieConfiguration serieConfiguration) {
		PlotOptions<?> plotOptions = this.getPlotOptions(serieConfiguration);
		Series series = this.createSeries().setName(serieConfiguration.getName()).setType(serieConfiguration.getType()).setPlotOptions(plotOptions);
		return series;
	}

	private PlotOptions<?> getPlotOptions(SerieConfiguration serieConfiguration) {
		PlotOptions<?> options = null;

		// Create implementation according to type
		switch (serieConfiguration.getType()) {
		case AREA:
			options = new AreaPlotOptions();
			break;
		case AREA_SPLINE:
			options = new AreaSplinePlotOptions();
			break;
		case BAR:
			options = new BarPlotOptions();
			break;
		case COLUMN:
			options = new ColumnPlotOptions();
			break;
		case LINE:
			options = new LinePlotOptions();
			break;
		case PIE:
			options = new PiePlotOptions();
			break;
		case SCATTER:
			options = new ScatterPlotOptions();
			break;
		case SPLINE:
			options = new SplinePlotOptions();
			break;
		default:
			options = new SplinePlotOptions();
			break;
		}

		// Set color
		if (serieConfiguration.getColor() != null && !serieConfiguration.getColor().isEmpty()) {
			options.setColor(serieConfiguration.getColor());
		}
		return options;
	}
}
