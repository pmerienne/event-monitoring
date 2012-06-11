package com.pmerienne.eventmonitoring.client.widget.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;

public class IndexEditor extends Composite implements Editor<Index> {

	private static IndexEditorUiBinder uiBinder = GWT.create(IndexEditorUiBinder.class);

	interface IndexEditorUiBinder extends UiBinder<Widget, IndexEditor> {
	}

	@UiField
	TextInput keyInput;

	@UiField
	BooleanInput ascendingInput;

	@UiField
	BooleanInput uniqueInput;

	@UiField
	BooleanInput dropDupsInput;

	public IndexEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public boolean validate() {
		boolean isKeyValid = this.keyInput.validate();
		this.ascendingInput.validate();
		this.uniqueInput.validate();
		this.dropDupsInput.validate();
		return isKeyValid;
	}

	@Override
	public Index getValue() {
		Index index = new Index();
		index.setKey(this.keyInput.getValue());
		index.setAscending(this.ascendingInput.getValue());
		index.setUnique(this.uniqueInput.getValue());
		index.setDropDuplicates(this.dropDupsInput.getValue());

		return index;
	}

	@Override
	public void setValue(Index index) {
		this.keyInput.setValue(index.getKey());
		this.ascendingInput.setValue(index.isAscending());
		this.uniqueInput.setValue(index.isUnique());
		this.dropDupsInput.setValue(index.isDropDuplicates());
	}

	@Override
	public void clear() {
		this.keyInput.setValue("");
		this.ascendingInput.setValue(false);
		this.uniqueInput.setValue(false);
		this.dropDupsInput.setValue(false);
	}

}
