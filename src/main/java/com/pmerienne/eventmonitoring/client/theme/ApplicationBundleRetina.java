package com.pmerienne.eventmonitoring.client.theme;

import com.googlecode.mgwt.ui.client.theme.base.HeaderCss;
import com.googlecode.mgwt.ui.client.theme.base.ListCss;
import com.googlecode.mgwt.ui.client.theme.base.MGWTClientBundleBaseThemeRetina;
import com.googlecode.mgwt.ui.client.theme.base.MainCss;

public interface ApplicationBundleRetina extends MGWTClientBundleBaseThemeRetina {

	@Source({ "com/googlecode/mgwt/ui/client/theme/base/css/main.css", "css/main.css" })
	MainCss getMainCss();

	@Source({ "com/googlecode/mgwt/ui/client/theme/base/css/header.css", "css/header.css" })
	HeaderCss getHeaderCss();

	@Source({ "com/googlecode/mgwt/ui/client/theme/base/css/list.css", "css/list.css" })
	ListCss getListCss();

}
