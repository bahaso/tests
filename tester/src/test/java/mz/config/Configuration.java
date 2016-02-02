package mz.config;

import mz.config.EnumList.EnumMobileDriver;
import mz.config.EnumList.EnumMobileWebDriver;
import mz.config.EnumList.EnumWebDriver;

public class Configuration {
	
	public static final EnumMobileDriver MOBILE_DRIVER = EnumMobileDriver.ANDROID;
	
	public static final EnumWebDriver WEB_DRIVER = EnumWebDriver.SAFARI;
	public static final EnumMobileWebDriver MOBILE_WEB_DRIVER = EnumMobileWebDriver.CHROME;
	public static final String WEB_BASE_URL = "http://10.10.24.10";
	
}

