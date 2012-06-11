package com.pmerienne.eventmonitoring.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ApplicationBundle extends ClientBundle {

	public final static ApplicationBundle INSTANCE = GWT.create(ApplicationBundle.class);

	ImageResource spinner();

}
