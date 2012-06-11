package com.pmerienne.eventmonitoring.client.widget.editor;

public interface Editor<T> {

	boolean validate();

	T getValue();

	void setValue(T t);

	void clear();
}
