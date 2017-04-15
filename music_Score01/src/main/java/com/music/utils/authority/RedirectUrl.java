package com.music.utils.authority;


public class RedirectUrl {
	/**
	 * 默认重定向URL
	 */
	public static String url;
	/**
	 * 登录URL
	 */
	public static String loginUrl;




	public static String getLoginUrl() {
		return loginUrl;
	}

	public static void setLoginUrl(String loginUrl) {
		RedirectUrl.loginUrl = loginUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		RedirectUrl.url = url;
	}
}
