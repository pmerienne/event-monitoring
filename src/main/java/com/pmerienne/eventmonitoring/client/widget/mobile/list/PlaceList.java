package com.pmerienne.eventmonitoring.client.widget.mobile.list;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.pmerienne.eventmonitoring.client.place.mobile.DashboardListPlace;

public class PlaceList extends BasicList<Place> implements HasCellSelectedHandler {

	public final static Place DASHBOARD_LIST_PLACE = new DashboardListPlace();

	private final static Map<Place, String> PLACE_NAMES = new HashMap<Place, String>();
	private final static Map<Place, String> PLACE_DESCRIPTION = new HashMap<Place, String>();

	public PlaceList() {
		super(new BasicCell<Place>() {
			@Override
			public String getTitleString(Place place) {
				return PLACE_NAMES.get(place);
			}

			@Override
			public String getSecondaryString(Place place) {
				return PLACE_DESCRIPTION.get(place);
			}
		});
		this.addPlace(DASHBOARD_LIST_PLACE, "Dashboards", "Get real time metrics on data collected from you information system");
	}

	public void addPlace(Place place, String name, String description) {
		PLACE_NAMES.put(place, name);
		PLACE_DESCRIPTION.put(place, description);
		this.elements.add(place);
		this.render();
	}

	public void removePlace(Place place) {
		PLACE_NAMES.remove(place);
		PLACE_DESCRIPTION.remove(place);
		this.elements.remove(place);
		this.render();
	}

}