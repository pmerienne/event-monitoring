package com.pmerienne.eventmonitoring.client.place.mobile;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

public class MobileAnimationMapper implements AnimationMapper {

	@Override
	public Animation getAnimation(Place oldPlace, Place newPlace) {
		// Home / Dashboard list
		if (oldPlace instanceof HomePlace && newPlace instanceof DashboardListPlace) {
			return Animation.SLIDE;
		} else if (oldPlace instanceof DashboardListPlace && newPlace instanceof HomePlace) {
			return Animation.SLIDE_REVERSE;
		}

		// Dashboard list / Dashboard
		if (oldPlace instanceof DashboardListPlace && newPlace instanceof DashboardPlace) {
			return Animation.SLIDE;
		} else if (oldPlace instanceof DashboardPlace && newPlace instanceof DashboardListPlace) {
			return Animation.SLIDE_REVERSE;
		}

		// Dashboard / Pie chart
		if (oldPlace instanceof DashboardPlace && newPlace instanceof PieChartPlace) {
			return Animation.SLIDE;
		} else if (oldPlace instanceof PieChartPlace && newPlace instanceof DashboardPlace) {
			return Animation.SLIDE_REVERSE;
		}

		// Dashboard / Time serie
		if (oldPlace instanceof DashboardPlace && newPlace instanceof TimeSeriePlace) {
			return Animation.SLIDE;
		} else if (oldPlace instanceof TimeSeriePlace && newPlace instanceof DashboardPlace) {
			return Animation.SLIDE_REVERSE;
		}

		// Dashboard / Event list
		if (oldPlace instanceof DashboardPlace && newPlace instanceof EventListPlace) {
			return Animation.SLIDE;
		} else if (oldPlace instanceof EventListPlace && newPlace instanceof DashboardPlace) {
			return Animation.SLIDE_REVERSE;
		}

		return Animation.FADE;
	}

}
