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
import com.pmerienne.eventmonitoring.client.widget.PieChart;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;

public class PieChartViewImpl extends Composite implements PieChartView {

	private static PieChartViewImplUiBinder uiBinder = GWT.create(PieChartViewImplUiBinder.class);

	interface PieChartViewImplUiBinder extends UiBinder<Widget, PieChartViewImpl> {
	}

	@UiField
	HasWidgets container;

	@UiField
	HTML pageTitle;

	private Presenter presenter;

	public PieChartViewImpl() {
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
	public PieChart setPieChartConfiguration(GraphConfiguration configuration) {
		this.clear();

		this.pageTitle.setText(configuration.getName());

		PieChart pieChart = new PieChart(configuration);
		this.container.add(pieChart);

		return pieChart;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
