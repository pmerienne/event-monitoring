package com.pmerienne.eventmonitoring.client.utils;

public class Notifications {

	private final static Integer DELAY = 10 * 1000;

	public static void info(String text) {
		Notifications.show("Info", text, ",notice");
	}

	public static void error(String text) {
		Notifications.show("Error", text, "error");
	}

	private static native void show(String title, String text) /*-{
		$wnd.$.pnotify({
			pnotify_title : title,
			pnotify_text : text,
			pnotify_shadow : true,
			pnotify_hide : true,
			pnotify_sticker : true
		});
	}-*/;

	private static native void show(String title, String text, String type) /*-{
		$wnd.$.pnotify({
			pnotify_title : title,
			pnotify_text : text,
			pnotify_type : type,
			pnotify_shadow : true,
			pnotify_hide : true,
			pnotify_sticker : true
		});
	}-*/;

	private static native void show(String title, String text, String type, boolean autohide, boolean sticker, boolean shadow) /*-{
		$wnd.$.pnotify({
			pnotify_title : title,
			pnotify_text : text,
			pnotify_type : type,
			pnotify_shadow : shadow,
			pnotify_hide : autohide,
			pnotify_sticker : sticker
		});
	}-*/;

}
