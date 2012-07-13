package com.pmerienne.eventmonitoring.client.widget.desktop.editor;

import java.util.Arrays;

import org.moxieapps.gwt.highcharts.client.Series.Type;

import com.google.gwt.user.client.ui.ListBox;

public class SerieTypeListBox extends ListBox {

	public SerieTypeListBox() {
		super();
		for (Type type : Type.values()) {
			this.addItem(type.name(), type.toString());
		}
	}

	public Type getSelectedType() {
		Type type = null;

		// Get selected index
		int selectedIndex = this.getSelectedIndex();

		// Find corresponding type
		Type[] types = Type.values();
		if (selectedIndex >= 0) {
			type = types[selectedIndex];
		}
		return type;
	}

	public void setSelectedType(Type type) {
		int index = Arrays.asList(Type.values()).indexOf(type);
		this.setSelectedIndex(index);
	}
}