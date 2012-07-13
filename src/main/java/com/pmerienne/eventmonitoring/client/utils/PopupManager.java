package com.pmerienne.eventmonitoring.client.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.client.widget.desktop.popup.ConfirmPopupCallback;
import com.pmerienne.eventmonitoring.client.widget.desktop.popup.Popup;
import com.pmerienne.eventmonitoring.client.widget.desktop.popup.PopupCallback;

public class PopupManager {

	private final static Popup PENDING_POPUP = new Popup();

	private static Popup CURRENT_POPUP;

	private final static List<Popup> WAITING_POPUPS = new ArrayList<Popup>();

	private final static Map<Popup, List<HandlerRegistration>> HANDLER_REGISTRATIONS = new HashMap<Popup, List<HandlerRegistration>>();

	public static void show(String title, Widget content) {
		final Popup popup = new Popup();
		popup.setHeader(title);
		popup.setContent(content);
		popup.getFooter().setVisible(false);
		registerHandler(popup, popup.getCloseButton().addClickHandler(new CancelButtonHandler(popup)));
		addToDisplayQueue(popup);
	}

	public static void show(String title, Widget content, final ConfirmPopupCallback callback) {
		final Popup popup = new Popup();
		popup.setHeader(title);
		popup.setContent(content);
		registerHandler(popup, popup.getOkButton().addClickHandler(new OkButtonHandler(popup, callback)));
		registerHandler(popup, popup.getCancelButton().addClickHandler(new CancelButtonHandler(popup, callback)));
		registerHandler(popup, popup.getCloseButton().addClickHandler(new CancelButtonHandler(popup, callback)));
		addToDisplayQueue(popup);
	}

	public static void show(String title, Widget content, final PopupCallback callback) {
		final Popup popup = new Popup();
		popup.setHeader(title);
		popup.setContent(content);
		popup.getCancelButton().setVisible(false);
		registerHandler(popup, popup.getOkButton().addClickHandler(new OkButtonHandler(popup, callback)));
		registerHandler(popup, popup.getCloseButton().addClickHandler(new CancelButtonHandler(popup)));
		addToDisplayQueue(popup);
	}

	public static void info(String text) {
		final Popup popup = new Popup();
		popup.setHeader("Information");
		popup.getCancelButton().setVisible(false);
		HTML content = new HTML(text);
		popup.setContent(content);
		registerHandler(popup, popup.getOkButton().addClickHandler(new OkButtonHandler(popup)));
		registerHandler(popup, popup.getCloseButton().addClickHandler(new CancelButtonHandler(popup)));
		addToDisplayQueue(popup);
	}

	public static void info(String text, final PopupCallback callback) {
		final Popup popup = new Popup();
		popup.setHeader("Information");
		popup.getCancelButton().setVisible(false);
		HTML content = new HTML(text);
		popup.setContent(content);
		registerHandler(popup, popup.getOkButton().addClickHandler(new OkButtonHandler(popup, callback)));
		registerHandler(popup, popup.getCloseButton().addClickHandler(new CancelButtonHandler(popup)));
		addToDisplayQueue(popup);
	}

	public static void confirm(String text, final ConfirmPopupCallback callback) {
		final Popup popup = new Popup();
		popup.setHeader("Confirmation");
		HTML content = new HTML(text);
		popup.setContent(content);
		registerHandler(popup, popup.getOkButton().addClickHandler(new OkButtonHandler(popup, callback)));
		registerHandler(popup, popup.getCancelButton().addClickHandler(new CancelButtonHandler(popup, callback)));
		registerHandler(popup, popup.getCloseButton().addClickHandler(new CancelButtonHandler(popup, callback)));
		addToDisplayQueue(popup);
	}

	public static void error(String text) {
		final Popup popup = new Popup();
		popup.setHeader("Error");
		popup.getCancelButton().setVisible(false);
		HTML content = new HTML(text);
		popup.setContent(content);
		registerHandler(popup, popup.getOkButton().addClickHandler(new OkButtonHandler(popup)));
		registerHandler(popup, popup.getCloseButton().addClickHandler(new CancelButtonHandler(popup)));
		addToDisplayQueue(popup);
	}

	public static void error(String text, final PopupCallback callback) {
		final Popup popup = new Popup();
		popup.setHeader("Error");
		popup.getCancelButton().setVisible(false);
		HTML content = new HTML(text);
		popup.setContent(content);
		registerHandler(popup, popup.getOkButton().addClickHandler(new OkButtonHandler(popup, callback)));
		registerHandler(popup, popup.getCloseButton().addClickHandler(new CancelButtonHandler(popup)));
		addToDisplayQueue(popup);
	}

	private static void addToDisplayQueue(Popup Popup) {
		if (CURRENT_POPUP == null) {
			CURRENT_POPUP = Popup;
			CURRENT_POPUP.show();
		} else {
			WAITING_POPUPS.add(Popup);
		}
	}

	private static void displayNextPopup() {
		for (HandlerRegistration handler : HANDLER_REGISTRATIONS.get(CURRENT_POPUP)) {
			handler.removeHandler();
		}
		HANDLER_REGISTRATIONS.remove(CURRENT_POPUP);
		CURRENT_POPUP = null;
		if (!WAITING_POPUPS.isEmpty()) {
			CURRENT_POPUP = WAITING_POPUPS.remove(0);
			CURRENT_POPUP.show();
		}
	}

	private static void registerHandler(Popup Popup, HandlerRegistration handler) {
		if (!HANDLER_REGISTRATIONS.containsKey(Popup)) {
			HANDLER_REGISTRATIONS.put(Popup, new ArrayList<HandlerRegistration>());
		}
		HANDLER_REGISTRATIONS.get(Popup).add(handler);
	}

	public static void showPending(String message) {
		PENDING_POPUP.getFooter().setVisible(false);
		PENDING_POPUP.getCloseButton().setVisible(false);
		PENDING_POPUP.getBody().setVisible(false);
		PENDING_POPUP.setHeader(message);
		PENDING_POPUP.show();
	}

	public static void hidePending() {
		PENDING_POPUP.close();
	}

	public static class OkButtonHandler implements ClickHandler {

		private Popup popup;

		private PopupCallback callback;

		public OkButtonHandler(Popup popup) {
			super();
			this.popup = popup;
		}

		public OkButtonHandler(Popup popup, PopupCallback callback) {
			this.popup = popup;
			this.callback = callback;
		}

		@Override
		public void onClick(ClickEvent event) {
			boolean mustClose = true;
			if (this.callback != null) {
				mustClose = this.callback.onOk();
			}

			if (mustClose) {
				this.popup.close();
				displayNextPopup();
			}
		}
	}

	public static class CancelButtonHandler implements ClickHandler {

		private Popup popup;

		private ConfirmPopupCallback callback;

		public CancelButtonHandler(Popup popup) {
			super();
			this.popup = popup;
		}

		public CancelButtonHandler(Popup popup, ConfirmPopupCallback callback) {
			this.popup = popup;
			this.callback = callback;
		}

		@Override
		public void onClick(ClickEvent event) {
			if (this.callback != null) {
				this.callback.onCancel();
			}
			this.popup.close();
			displayNextPopup();
		}
	}
}
