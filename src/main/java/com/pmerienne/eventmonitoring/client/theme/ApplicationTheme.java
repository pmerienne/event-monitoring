package com.pmerienne.eventmonitoring.client.theme;

import com.google.gwt.core.client.GWT;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.theme.MGWTClientBundle;
import com.googlecode.mgwt.ui.client.theme.MGWTTheme;

public class ApplicationTheme implements MGWTTheme {

	private MGWTClientBundle bundle;

	public ApplicationTheme() {
		if (MGWT.getOsDetection().isIOs()) {
			if (MGWT.getOsDetection().isRetina()) {
				bundle = (ApplicationBundleRetina) GWT.create(ApplicationBundleRetina.class);
			} else {
				bundle = (AppliactionBundleNonRetina) GWT.create(AppliactionBundleNonRetina.class);
			}
		} else {
			bundle = (ApplicationBundleRetina) GWT.create(ApplicationBundleRetina.class);
		}
	}

	@Override
	public MGWTClientBundle getMGWTClientBundle() {
		return bundle;
	}
}
