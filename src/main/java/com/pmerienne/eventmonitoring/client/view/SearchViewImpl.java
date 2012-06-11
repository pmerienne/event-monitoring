package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.client.widget.NavigationBar;
import com.pmerienne.eventmonitoring.client.widget.editor.CriteriaInput;
import com.pmerienne.eventmonitoring.client.widget.editor.NumberInput;
import com.pmerienne.eventmonitoring.client.widget.editor.TimeRangeInput;
import com.pmerienne.eventmonitoring.client.widget.table.EventTable;
import com.pmerienne.eventmonitoring.client.widget.table.EventTable.DataProvider;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.configuration.ColumnConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.SearchResults;

public class SearchViewImpl extends Composite implements SearchView {

	private static SearchViewImplUiBinder uiBinder = GWT.create(SearchViewImplUiBinder.class);

	interface SearchViewImplUiBinder extends UiBinder<Widget, SearchViewImpl> {
	}

	@UiField
	NavigationBar navigationBar;

	@UiField
	NumberInput nbResultsInput;

	@UiField
	CriteriaInput criteriaInput;

	@UiField
	TimeRangeInput timeRangeInput;

	@UiField
	HTMLPanel tableContainer;

	private EventTable eventTable;

	public SearchViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		TableConfiguration configuration = new TableConfiguration("Results", 10, 60 * 1000L);
		configuration.getColumnConfigurations().add(new ColumnConfiguration("_id", "ID", true, "20%"));
		configuration.getColumnConfigurations().add(new ColumnConfiguration("date", "Date", true, "20%"));
		configuration.getColumnConfigurations().add(new ColumnConfiguration("type", "Type", true, "20%"));
		configuration.getColumnConfigurations().add(new ColumnConfiguration("data", "Data", true, "40%"));
		this.eventTable = new EventTable(configuration);
		this.tableContainer.add(this.eventTable);
	}

	@UiHandler("searchButton")
	protected void onSearchClicked(ClickEvent event) {
		this.clearResults();
		if (this.validate()) {
			this.updateTableConfiguration();
			this.eventTable.refresh();
		}
	}

	@Override
	public void clear() {
		this.nbResultsInput.clear();
		this.nbResultsInput.setValue("10");
		this.criteriaInput.clear();
		this.timeRangeInput.clear();

		this.clearResults();
	}

	public void clearResults() {
		this.eventTable.clearResults();
	}

	@Override
	public void setResults(SearchResults results) {
		this.eventTable.setRowCount(results.getTotalCount().intValue(), true);
		this.eventTable.setRowData(results.getRequest().getStart(), results.getEvents());
	}

	@Override
	public void addDataProvider(DataProvider dataProvider) {
		this.updateTableConfiguration();
		this.eventTable.addDataProvider(dataProvider);
	}

	@Override
	public void removeDataProvider(DataProvider dataProvider) {
		// this.eventTable.addDataProvider(dataProvider)
	}

	@Override
	public void setAvailableDashboards(List<Dashboard> dashboards) {
		this.navigationBar.setAvailableDashboards(dashboards);
	}

	private boolean validate() {
		// Nb results validation
		boolean isNbResultsValid = this.nbResultsInput.validate();

		// Criterion validation
		boolean isCriteriaValid = this.criteriaInput.validate();

		return isNbResultsValid && isCriteriaValid;
	}

	private void updateTableConfiguration() {
		this.eventTable.getConfiguration().setNbResults(this.nbResultsInput.getValueAsInteger());
		this.eventTable.getConfiguration().setCriteria(this.criteriaInput.getValue());
		this.eventTable.getConfiguration().setTimeRange(this.timeRangeInput.getValue());
	}

}
