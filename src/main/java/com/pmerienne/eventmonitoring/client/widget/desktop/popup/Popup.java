package com.pmerienne.eventmonitoring.client.widget.desktop.popup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class Popup extends Composite {

	private static PopupUiBinder uiBinder = GWT.create(PopupUiBinder.class);

	interface PopupUiBinder extends UiBinder<Widget, Popup> {
	}

	@UiField
	HeadingElement header;

	@UiField
	HTMLPanel body;

	@UiField
	HTMLPanel footer;

	@UiField
	Button okButton;

	@UiField
	Button cancelButton;

	@UiField
	Button closeButton;

	/**
	 * "Popup" filling page's background behind the real popup.
	 */
	private PopupPanel backgroundPanel;

	/**
	 * Real popup
	 */
	private PopupPanel popup;

	public Popup() {
		this.backgroundPanel = new PopupPanel();
		this.addGlassStyle(this.backgroundPanel);

		this.popup = new PopupPanel(false, true);
		this.popup.addStyleName("modal");
		this.popup.setWidget(uiBinder.createAndBindUi(this));

		this.setElement(DOM.createDiv());
	}

	public void close() {
		this.popup.hide();
		this.backgroundPanel.hide();
	}

	public void show() {
		this.backgroundPanel.center();
		this.popup.center();
	}

	public void setContent(Widget w) {
		this.body.clear();
		this.body.add(w);
	}

	public void setHeader(String html) {
		this.header.setInnerHTML(html);
	}

	private void addGlassStyle(PopupPanel glass) {
		// Plein écran
		DOM.setStyleAttribute(glass.getElement(), "width", "100%");
		DOM.setStyleAttribute(glass.getElement(), "height", "100%");
		// Fond noir
		DOM.setStyleAttribute(glass.getElement(), "backgroundColor", "#000000");
		// Transparence
		DOM.setStyleAttribute(glass.getElement(), "opacity", "0.5");
		DOM.setStyleAttribute(glass.getElement(), "filter", " alpha(opacity=0.5)");
		// Pas de bordure
		DOM.setStyleAttribute(glass.getElement(), "border", "none");
	}

	protected void onLoad() {
		this.show();
	}

	protected void onUnload() {
		this.close();
	}

	public Panel getBody() {
		return this.body;
	}

	public Panel getFooter() {
		return this.footer;
	}

	public Button getOkButton() {
		return this.okButton;
	}

	public Button getCancelButton() {
		return this.cancelButton;
	}

	public Button getCloseButton() {
		return closeButton;
	}

}
