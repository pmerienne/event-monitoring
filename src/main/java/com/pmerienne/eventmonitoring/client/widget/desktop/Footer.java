package com.pmerienne.eventmonitoring.client.widget.desktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Footer extends Composite {

	private static FooterUiBinder uiBinder = GWT.create(FooterUiBinder.class);

	interface FooterUiBinder extends UiBinder<Widget, Footer> {
	}

	@UiField
	AnchorElement mobileLink;

	public Footer() {
		initWidget(uiBinder.createAndBindUi(this));

		String href = GWT.getHostPageBaseURL() + "mobile.html";
		this.mobileLink.setHref(href);
	}

}
