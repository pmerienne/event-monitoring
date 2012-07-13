package com.pmerienne.eventmonitoring.client.widget.desktop.editor;

public interface Editor<T> {

	boolean validate();

	T getValue();

	void setValue(T t);

	void clear();
}
