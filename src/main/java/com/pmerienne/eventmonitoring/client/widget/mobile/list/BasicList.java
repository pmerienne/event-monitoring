package com.pmerienne.eventmonitoring.client.widget.mobile.list;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.theme.base.ListCss;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

public abstract class BasicList<T> extends CellListWithHeader<T> implements HasCellSelectedHandler {

	public final static Integer CHAR_LIMIT = 220;

	protected LinkedList<T> elements = new LinkedList<T>();

	private final static ListCss css = MGWTStyle.getTheme().getMGWTClientBundle().getListCss();

	public BasicList(Cell<T> cell) {
		super(cell);
		((HTML) this.getHeader()).setVisible(false);
	}

	public void setHeader(String text) {
		((HTML) this.getHeader()).setVisible(true);
		this.getHeader().setText(text);
	}

	public void clear() {
		this.elements = new LinkedList<T>();
		this.render();
	}

	public void setElements(List<T> elements) {
		this.elements = new LinkedList<T>(elements);
		this.render();
	}

	public void render() {
		this.getCellList().render(this.elements);
	}

	public T getElement(int index) {
		return this.elements.get(index);
	}

	@Override
	public HandlerRegistration addCellSelectedHandler(CellSelectedHandler cellSelectedHandler) {
		return this.getCellList().addCellSelectedHandler(cellSelectedHandler);
	}

	public void setRound(boolean round) {
		if (round) {
			((HTML) this.getHeader()).addStyleName(css.round());
		} else {
			((HTML) this.getHeader()).removeStyleName(css.round());
		}
		this.getCellList().setRound(round);
	}

}