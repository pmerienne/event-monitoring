package com.pmerienne.eventmonitoring.client.widget.table;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.ColumnSortList.ColumnSortInfo;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.RangeChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.pmerienne.eventmonitoring.client.utils.PopupManager;
import com.pmerienne.eventmonitoring.client.widget.EventDetail;
import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.configuration.ColumnConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest.SortedField;

public class EventTable extends Composite {

	private static EventTableUiBinder uiBinder = GWT.create(EventTableUiBinder.class);

	interface EventTableUiBinder extends UiBinder<Widget, EventTable> {
	}

	@UiField
	HeadingElement tableName;

	@UiField
	HTMLPanel container;

	@UiField
	SimplePager pager;

	private CellTable<Event> table;

	private AsyncDataProvider<Event> asyncDataProvider;

	private TableConfiguration configuration;

	private List<EventDataColumn> columns = new ArrayList<EventDataColumn>();

	private boolean pagingActivated = false;

	public EventTable(TableConfiguration configuration) {
		initWidget(uiBinder.createAndBindUi(this));
		this.configuration = configuration;
		this.table = new CellTable<Event>();

		// Display event detail on click
		final SingleSelectionModel<Event> selectionModel = new SingleSelectionModel<Event>();
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				EventDetail eventDetail = new EventDetail(selectionModel.getSelectedObject());
				PopupManager.show("Event detail", eventDetail);
			}
		});
		this.table.setSelectionModel(selectionModel);

		// Set name
		this.tableName.setInnerHTML(configuration.getName());

		// Set width
		this.table.setWidth("100%", true);

		// Sort handler
		AsyncHandler columnSortHandler = new AsyncHandler(this.table);
		this.table.addColumnSortHandler(columnSortHandler);

		// Event count
		this.table.setRowCount(configuration.getNbResults(), true);
		this.table.setVisibleRange(0, configuration.getNbResults());

		// Add column
		for (ColumnConfiguration columnConfiguration : configuration.getColumnConfigurations()) {
			// Create column
			EventDataColumn column = new EventDataColumn(columnConfiguration.getTarget(), columnConfiguration.isSortable());

			// Add to table
			this.table.addColumn(column, columnConfiguration.getLabel());
			this.table.setColumnWidth(column, columnConfiguration.getWidth());

			// Add sort if needed
			if (columnConfiguration.isSortable()) {
				this.table.getColumnSortList().push(column);
			}

			// Add to column list
			this.columns.add(column);
		}

		// Add table to container
		this.container.add(this.table);

		// Add pager
		this.pager.setDisplay(this.table);

	}

	@UiHandler("refreshButton")
	protected void onRefreshClicked(ClickEvent event) {
		this.refresh();
	}

	public void addDataProvider(final DataProvider dataProvider) {
		this.asyncDataProvider = new AsyncDataProvider<Event>() {
			@Override
			protected void onRangeChanged(HasData<Event> display) {
				// Get range info
				int start = display.getVisibleRange().getStart();
				int end = start + display.getVisibleRange().getLength();

				// Get the sorted field
				List<SortedField> sortedFields = new ArrayList<SearchRequest.SortedField>();

				final ColumnSortList sortList = EventTable.this.table.getColumnSortList();
				int count = sortList.size();
				for (int i = 0; i < count; i++) {
					ColumnSortInfo info = sortList.get(i);
					if (info.getColumn() instanceof EventDataColumn) {
						sortedFields.add(new SortedField(((EventDataColumn) info.getColumn()).getField(), info.isAscending()));
					}
				}

				// Create request
				SearchRequest request = new SearchRequest(EventTable.this.configuration, start, end, EventTable.this.pagingActivated, sortedFields);

				// Call data provider
				dataProvider.onRequestChange(request);
			}
		};
		this.asyncDataProvider.addDataDisplay(this.table);
	}

	public void refresh() {
		this.table.setVisibleRange(0, this.configuration.getNbResults());
		RangeChangeEvent.fire(this.table, new Range(0, this.configuration.getNbResults()));
	}

	public void setRowCount(int size, boolean isExact) {
		this.table.setRowCount(size, isExact);
	}

	public final void setRowData(List<Event> values) {
		this.setRowData(0, values);
	}

	public void setRowData(int start, List<Event> values) {
		this.table.setRowData(start, values);
	}

	public void setVisibleRange(int start, int length) {
		this.table.setVisibleRange(start, length);
	}

	public TableConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(TableConfiguration configuration) {
		this.configuration = configuration;
	}

	public static interface DataProvider {
		void onRequestChange(SearchRequest request);
	}

	public void clearResults() {
		this.table.setRowCount(0);
	}

	public boolean isPagingActivated() {
		return pagingActivated;
	}

	public void setPagingActivated(boolean pagingActivated) {
		this.pager.setVisible(pagingActivated);
		this.pagingActivated = pagingActivated;
	}

}
