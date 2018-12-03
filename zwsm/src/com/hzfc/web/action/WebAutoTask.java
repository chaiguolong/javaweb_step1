package com.hzfc.web.action;

import com.hzfc.superadmin.ad.action.WebStatictaskAction;
import com.hzfc.superadmin.ad.entity.WebStatictask;

public class WebAutoTask {
	
	private WebStatictaskAction _webStatictaskAction;

	public WebStatictaskAction getWebStatictaskAction() {
		return _webStatictaskAction;
	}

	public void setWebStatictaskAction(WebStatictaskAction webStatictaskAction) {
		this._webStatictaskAction = webStatictaskAction;
	}

	public void run() {
		WebStatictask ws = new WebStatictask();
		ws.setStatictaskid(33018445L);
		_webStatictaskAction.setWebStatictask(ws);
		_webStatictaskAction.doCreate();
		ws = new WebStatictask();
		ws.setStatictaskid(33018455L);
		_webStatictaskAction.setWebStatictask(ws);
		_webStatictaskAction.doCreate();
	}
}
