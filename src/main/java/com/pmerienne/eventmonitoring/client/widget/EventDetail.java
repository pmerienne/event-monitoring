package com.pmerienne.eventmonitoring.client.widget;

import java.util.Map;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.pmerienne.eventmonitoring.shared.model.Event;

public class EventDetail extends HTMLPanel {

	public EventDetail() {
		super("");
	}

	public EventDetail(Event event) {
		this();
		this.setEvent(event);
	}

	public void setEvent(Event event) {
		UListElement uListElement = Document.get().createULElement();
		uListElement.appendChild(this.createLI("id", event.getId()));
		uListElement.appendChild(this.createLI("type", event.getType()));
		uListElement.appendChild(this.createLI("date", event.getDate()));
		uListElement.appendChild(this.createLI("data", event.getData()));
		this.getElement().appendChild(uListElement);
	}

	private LIElement createLI(Object key, Object value) {
		LIElement element = Document.get().createLIElement();
		if (value instanceof Map<?, ?>) {
			element.setInnerHTML(key + " : ");
			UListElement ul = this.createUL((Map<?, ?>) value);
			element.appendChild(ul);
		} else {
			element.setInnerHTML(key + " : " + value);
		}
		return element;
	}

	private UListElement createUL(Map<?, ?> map) {
		UListElement element = Document.get().createULElement();
		for (Object childKey : map.keySet()) {
			element.appendChild(this.createLI(childKey, map.get(childKey)));
		}
		return element;
	}
}
