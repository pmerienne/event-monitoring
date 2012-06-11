package com.pmerienne.eventmonitoring.client.widget.editor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gwt.user.client.ui.ListBox;

public class TimeRangeListBox extends ListBox {

	private final static Map<String, Long> DURATIONS = new HashMap<String, Long>();

	static {
		DURATIONS.put("Last minute", 60 * 1000L);
		DURATIONS.put("Last hour", 60 * 60 * 1000L);
		DURATIONS.put("Last 12 hours", 12 * 60 * 60 * 1000L);
		DURATIONS.put("Last day", 24 * 60 * 60 * 1000L);
		DURATIONS.put("Last week", 7 * 24 * 60 * 60 * 1000L);
		DURATIONS.put("Last month", 30 * 7 * 24 * 60 * 60 * 1000L);
	}

	public TimeRangeListBox() {
		super();

		for (String key : DURATIONS.keySet()) {
			this.addItem(key, Long.toString(DURATIONS.get(key)));
		}
	}

	public Long getSelectedDuration() {
		Long duration = 60 * 1000L;
		// Get selected index
		int selectedIndex = this.getSelectedIndex();
		if (selectedIndex >= 0 && selectedIndex < DURATIONS.size()) {
			duration = (Long) DURATIONS.values().toArray()[selectedIndex];
		}

		return duration;
	}

	public void setSelectedDuration(Long duration) {
		Integer index = null;
		int i = 0;
		Iterator<String> iterator = DURATIONS.keySet().iterator();

		while (iterator.hasNext() && index == null) {
			String key = iterator.next();
			if (DURATIONS.get(key).equals(duration)) {
				index = i;
			}
			i++;
		}

		if (index != null) {
			this.setSelectedIndex(index);
		}
	}
}
