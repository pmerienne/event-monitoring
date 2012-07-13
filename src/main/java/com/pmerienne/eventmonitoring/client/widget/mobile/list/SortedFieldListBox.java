package com.pmerienne.eventmonitoring.client.widget.mobile.list;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.mgwt.ui.client.widget.MListBox;
import com.pmerienne.eventmonitoring.shared.model.request.SearchRequest.SortedField;

public class SortedFieldListBox extends MListBox {

	private List<SortedField> sortedFields = new ArrayList<SortedField>();

	public SortedFieldListBox() {
		super();
	}

	public SortedField getSelectedSortedField() {
		try {
			int index = this.getSelectedIndex();
			return sortedFields.get(index);
		} catch (Exception ex) {
			return null;
		}
	}

	public void setSortedField(SortedField sortedField) {
		int index = this.sortedFields.indexOf(sortedField);
		this.setSelectedIndex(index);
	}

	@Override
	public void clear() {
		super.clear();
		this.sortedFields.clear();
	}

	public void add(String label, SortedField sortedField) {
		this.sortedFields.add(sortedField);
		this.addItem(label);
	}
}