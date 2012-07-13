package com.pmerienne.eventmonitoring.client.view.mobile;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.widget.base.HasRefresh;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowFooter;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowHeader;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowStandardHandler;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowWidget;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel.PullWidget;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.pmerienne.eventmonitoring.client.widget.mobile.list.EventList;
import com.pmerienne.eventmonitoring.client.widget.mobile.list.SortedFieldListBox;
import com.pmerienne.eventmonitoring.shared.model.Event;
import com.pmerienne.eventmonitoring.shared.model.configuration.ColumnConfiguration;
import com.pmerienne.eventmonitoring.shared.model.configuration.TableConfiguration;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest.SortedField;

public class EventListViewImpl extends Composite implements EventListView {

	private static EventListViewImplUiBinder uiBinder = GWT.create(EventListViewImplUiBinder.class);

	interface EventListViewImplUiBinder extends UiBinder<Widget, EventListViewImpl> {
	}

	@UiField
	PullPanel pullPanel;

	@UiField
	HTML pageTitle;

	@UiField
	SortedFieldListBox sortedFieldListBox;

	@UiField
	Widget sortEntry;

	private Presenter presenter;

	private EventList eventList;

	private List<HandlerRegistration> registrations = new ArrayList<HandlerRegistration>();

	public EventListViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		// Init pull to refresh
		PullArrowHeader pullArrowHeader = new PullArrowHeader();
		this.pullPanel.setHeader(pullArrowHeader);
		this.pullPanel.setHeaderPullhandler(new PullToRefreshHandler(pullArrowHeader, this.pullPanel, "Pull down to refresh") {
			@Override
			public void onPullAction(PullWidget pullWidget) {
				super.onPullAction(pullWidget);
				presenter.refresh();
			}
		});
		PullArrowFooter pullArrowFooter = new PullArrowFooter();
		this.pullPanel.setFooter(pullArrowFooter);
		this.pullPanel.setFooterPullHandler(new PullToRefreshHandler(pullArrowFooter, this.pullPanel, "Pull up to refresh") {
			@Override
			public void onPullAction(PullWidget pullWidget) {
				super.onPullAction(pullWidget);
				presenter.refresh();
			}
		});
	}

	@UiHandler("backButton")
	protected void onBackTaped(TapEvent event) {
		this.presenter.goBack();
	}

	@UiHandler("sortedFieldListBox")
	protected void onSortChanged(ChangeEvent event) {
		this.presenter.refresh();
	}

	@Override
	public void setConfigurations(TableConfiguration configuration) {
		this.clear();

		// Set list name
		this.pageTitle.setText(configuration.getName());

		// Init sort
		this.sortedFieldListBox.clear();
		boolean sortableFields = false;
		for (ColumnConfiguration columnConfiguration : configuration.getColumnConfigurations()) {
			sortableFields = sortableFields || columnConfiguration.isSortable();
			String label = columnConfiguration.getLabel();
			String target = columnConfiguration.getTarget();
			this.sortedFieldListBox.add("Ascending " + label, new SortedField(target, true));
			this.sortedFieldListBox.add("Descending " + label, new SortedField(target, false));
		}
		this.sortEntry.setVisible(sortableFields);
		this.sortedFieldListBox.setSelectedIndex(-1);

		// Init event list
		this.eventList = new EventList(configuration.getColumnConfigurations());
		HandlerRegistration registration = this.eventList.addCellSelectedHandler(new CellSelectedHandler() {
			@Override
			public void onCellSelected(CellSelectedEvent event) {
				// Integer index = event.getIndex();
				// Event selectedEvent = eventList.getEvent(index);
				// presenter.goTo(new EventPlace(selectedEvent.getId()));
			}
		});
		this.registrations.add(registration);
		this.pullPanel.add(this.eventList);
	}

	@Override
	public void setEvents(List<Event> events) {
		if (this.eventList != null) {
			this.eventList.setElements(events);
			this.pullPanel.refresh();
		}
	}

	@Override
	public void clear() {
		if (this.eventList != null) {
			this.eventList.removeFromParent();
			this.eventList = null;
		}

		for (HandlerRegistration registration : this.registrations) {
			registration.removeHandler();
		}
		this.registrations.clear();
	}

	@Override
	public SortedField getSortedField() {
		SortedField sortedField = this.sortedFieldListBox.getSelectedSortedField();
		return sortedField;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	private abstract static class PullToRefreshHandler extends PullArrowStandardHandler {

		public PullToRefreshHandler(PullArrowWidget pullArrow, HasRefresh pullPanel, String text) {
			super(pullArrow, pullPanel);
			this.setNormalText(text);
			this.setPulledText(text);
		}
	}
}
