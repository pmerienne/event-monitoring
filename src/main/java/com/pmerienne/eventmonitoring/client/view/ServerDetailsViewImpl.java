package com.pmerienne.eventmonitoring.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.client.widget.NavigationBar;
import com.pmerienne.eventmonitoring.client.widget.TimeSeriesGraph;
import com.pmerienne.eventmonitoring.shared.model.Dashboard;
import com.pmerienne.eventmonitoring.shared.model.administration.DatabaseInformation;
import com.pmerienne.eventmonitoring.shared.model.configuration.GraphConfiguration;

public class ServerDetailsViewImpl extends Composite implements ServerDetailsView {

	private static ServerDetailsViewImplUiBinder uiBinder = GWT.create(ServerDetailsViewImplUiBinder.class);

	interface ServerDetailsViewImplUiBinder extends UiBinder<Widget, ServerDetailsViewImpl> {
	}

	@UiField
	NavigationBar navigationBar;

	@UiField
	Label name;

	@UiField
	Label objects;

	@UiField
	Label dataSize;

	@UiField
	Label storageSize;

	@UiField
	Label indexSize;

	@UiField
	Label fileSize;

	@UiField
	HTMLPanel graphContainer;

	public ServerDetailsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public TimeSeriesGraph initLastEventsGraph(GraphConfiguration graphConfiguration) {
		TimeSeriesGraph graph = new TimeSeriesGraph(graphConfiguration);
		this.graphContainer.add(graph);

		return graph;
	}

	@Override
	public void setAvailableDashboards(List<Dashboard> dashboards) {
		this.navigationBar.setAvailableDashboards(dashboards);
	}

	@Override
	public void setDatabaseInformation(DatabaseInformation databaseInformation) {
		this.name.setText(databaseInformation.getName());
		this.objects.setText(databaseInformation.getObjects().toString());
		this.dataSize.setText(humanReadableByteCount(databaseInformation.getDataSize()));
		this.storageSize.setText(humanReadableByteCount(databaseInformation.getStorageSize()));
		this.indexSize.setText(humanReadableByteCount(databaseInformation.getIndexSize()));
		this.fileSize.setText(humanReadableByteCount(databaseInformation.getFileSize()));
	}

	@Override
	public void clear() {
		this.graphContainer.clear();
	}

	private static String humanReadableByteCount(long bytes) {
		int unit = 1024;
		if (bytes < unit) {
			return bytes + " B";
		}
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = "KMGTPE".charAt(exp - 1) + "iB";
		return NumberFormat.getFormat("#.0").format(bytes / Math.pow(unit, exp)) + " " + pre;
	}
}
