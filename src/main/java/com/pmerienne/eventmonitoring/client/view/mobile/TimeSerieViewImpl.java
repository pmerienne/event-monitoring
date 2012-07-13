package com.pmerienne.eventmonitoring.client.view.mobile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.pmerienne.eventmonitoring.client.widget.TimeSeriesGraph;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;

public class TimeSerieViewImpl extends Composite implements TimeSerieView {

	private static TimeSerieViewImplUiBinder uiBinder = GWT.create(TimeSerieViewImplUiBinder.class);

	interface TimeSerieViewImplUiBinder extends UiBinder<Widget, TimeSerieViewImpl> {
	}

	@UiField
	HasWidgets container;

	@UiField
	HTML pageTitle;

	private Presenter presenter;

	public TimeSerieViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("backButton")
	protected void onBackTaped(TapEvent event) {
		this.presenter.goBack();
	}

	@Override
	public void clear() {
		this.pageTitle.setText("");
		this.container.clear();
	}

	@Override
	public TimeSeriesGraph setTimeSerieConfiguration(GraphConfiguration configuration) {
		this.clear();

		this.pageTitle.setText(configuration.getName());

		TimeSeriesGraph TimeSerie = new TimeSeriesGraph(configuration);
		this.container.add(TimeSerie);

		return TimeSerie;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
