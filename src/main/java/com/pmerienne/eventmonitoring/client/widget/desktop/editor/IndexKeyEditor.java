package com.pmerienne.eventmonitoring.client.widget.desktop.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.shared.model.administration.IndexKey;

public class IndexKeyEditor extends Composite implements Editor<IndexKey> {

	private static IndexKeyEditorUiBinder uiBinder = GWT.create(IndexKeyEditorUiBinder.class);

	interface IndexKeyEditorUiBinder extends UiBinder<Widget, IndexKeyEditor> {
	}

	@UiField
	TextInput keyInput;

	@UiField
	BooleanInput ascendingInput;

	private IndexKey indexKey;

	public IndexKeyEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("removeButton")
	protected void onRemoveClicked(ClickEvent event) {
		this.removeFromParent();
	}

	@Override
	public boolean validate() {
		return this.keyInput.validate();
	}

	@Override
	public IndexKey getValue() {
		if (this.indexKey == null) {
			this.indexKey = new IndexKey();
		}

		this.indexKey.setName(this.keyInput.getValue());
		this.indexKey.setAscending(this.ascendingInput.getValue());

		return this.indexKey;
	}

	@Override
	public void setValue(IndexKey indexKey) {
		this.indexKey = indexKey;

		this.keyInput.setValue(indexKey.getName());
		this.ascendingInput.setValue(indexKey.getAscending());
	}

	@Override
	public void clear() {
		this.keyInput.clear();
		this.ascendingInput.clear();
	}
}
