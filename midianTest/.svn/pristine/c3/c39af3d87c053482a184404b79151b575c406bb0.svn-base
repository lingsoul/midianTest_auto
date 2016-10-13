/**
 * Copyright @ 2016jkzl. All rights reserved
 */
package com.midian.webtest.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author peter.Chen
 * @version 1.0
 *          <p>
 *          operation date operator content 2016/9/6 20:30 peter.Chen new
 * @Description:
 * @date 2016/9/6 20:30
 */
public class LocalWebDriverFactory {
	private static final String FIRE_FOX_KEY = "webdriver.firefox.bin";
	private static final String FIRE_FOX_PATH = "D:\\软件\\火狐浏览器\\firefox.exe";

	private static final String CHROME_KEY = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";

	private static final String IE_KEY = "webdriver.ie.driver";
	private static final String IE_PATH = "C:\\Users\\jling\\workspace\\testpro\\IEDriverServer.exe";

	public static WebDriver getBrowserDriver() {
		return getFireFoxDriver();
	}
	
	public static WebDriver getFireFoxDriver() {
		System.setProperty(FIRE_FOX_KEY, FIRE_FOX_PATH);
		WebDriver instance = new FirefoxDriver();
		return instance;
	}

	public static WebDriver getChromeDriver() {
		System.setProperty(CHROME_KEY, CHROME_PATH);
		WebDriver instance = new ChromeDriver();
		if (CHROME_PATH == null || CHROME_PATH == "" || CHROME_PATH.equals("")) {
			return instance;
		}
		return instance;
	}

	public static WebDriver getIEDriver() {
		System.setProperty(IE_KEY, IE_PATH);
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		WebDriver instance = new InternetExplorerDriver(ieCapabilities);

		if (IE_PATH == null || IE_PATH == "" || IE_PATH.equals("")) {
			return instance;
		}
		return instance;
	}

}
