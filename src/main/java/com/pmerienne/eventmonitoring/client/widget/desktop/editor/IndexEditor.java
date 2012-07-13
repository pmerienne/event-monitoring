package com.pmerienne.eventmonitoring.client.widget.desktop.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.pmerienne.eventmonitoring.shared.model.administration.Index;
import com.pmerienne.eventmonitoring.shared.model.administration.IndexKey;

public class IndexEditor extends Composite implements Editor<Index> {

	private static IndexEditorUiBinder uiBinder = GWT.create(IndexEditorUiBinder.class);

	interface IndexEditorUiBinder extends UiBinder<Widget, IndexEditor> {
	}

	@UiField
	HTMLPanel keysContainer;

	@UiField
	BooleanInput uniqueInput;

	@UiField
	BooleanInput dropDupsInput;

	private Index index;

	public IndexEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("addKeyButton")
	protected void onAddKeyCliked(ClickEvent event) {
		IndexKeyEditor editor = new IndexKeyEditor();
		this.keysContainer.add(editor);
	}

	@Override
	public boolean validate() {
		// Columns configuration
		boolean areKeysValid = this.keysContainer.getWidgetCount() > 0;
		for (int i = 0; i < this.keysContainer.getWidgetCount(); i++) {
			Widget w = this.keysContainer.getWidget(i);
			if (w instanceof IndexKeyEditor) {
				areKeysValid = ((Editor<?>) w).validate() && areKeysValid;
			}
		}

		this.uniqueInput.validate();
		this.dropDupsInput.validate();
		return areKeysValid;
	}

	@Override
	public Index getValue() {
		if (this.index == null) {
			this.index = new Index();
		}

		this.index.setUnique(this.uniqueInput.getValue());
		this.index.setDropDuplicates(this.dropDupsInput.getValue());

		this.index.getKeys().clear();
		for (int i = 0; i < this.keysContainer.getWidgetCount(); i++) {
			Widget w = this.keysContainer.getWidget(i);
			if (w instanceof IndexKeyEditor) {
				IndexKey indexKey = ((IndexKeyEditor) w).getValue();
				this.index.getKeys().add(indexKey);
			}
		}

		return index;
	}

	@Override
	public void setValue(Index index) {
		this.clear();

		this.index = index;
		this.uniqueInput.setValue(index.isUnique());
		this.dropDupsInput.setValue(index.isDropDuplicates());

		for (IndexKey indexKey : index.getKeys()) {
			IndexKeyEditor editor = new IndexKeyEditor();
			editor.setValue(indexKey);
			this.keysContainer.add(editor);
		}
	}

	@Override
	public void clear() {
		this.keysContainer.clear();
		this.uniqueInput.setValue(false);
		this.dropDupsInput.setValue(false);
	}

}
