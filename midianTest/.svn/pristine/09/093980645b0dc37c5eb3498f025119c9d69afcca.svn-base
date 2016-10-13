package com.midian.webtest.use;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.midian.webtest.core.LocalWebDriverFactory;
import com.midian.webtest.utils.SnapShot;

public class WzLoginTest {
	public WebDriver driver;
	String loginurl = "http://test.vzhou.net/member.php?act=login&";
	String loginsuccessurl = "http://test.vzhou.net/index.php?act=welcome&do=";

	@Test
	// (dataProvider = "userLogin", dataProviderClass = DataProviderTest.class)
	// 登录测试
	public void loginTest() {
		loginFail("fdsafsa", "fsafsda");
		loginFail("admin", "fsafsd");
		loginFail("dsafasdf", "VCP.com.net");
		loginFail("admin", "vcp.com.net");
		loginSuccess("admin", "VCP.com.net");
		driver.quit();
	}

	// 等待waittime秒内未查询到内容，执行失败
	public void waitfortxt(WebDriver driver, Integer waittime, final String waittxt) {
		WebDriverWait waitlogin = new WebDriverWait(driver, waittime);
		waitlogin.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.partialLinkText(waittxt));
			}
		});
	}

	public void waitofimplicitly(Integer waittime) {
		driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
	}

	// 延时等待
	public void waitmsec(Integer msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 截图
	public void snapshut(String picturename) {
		SnapShot snapshut = new SnapShot();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = format.format(date);
		snapshut.snapshot((TakesScreenshot) driver, picturename + time + ".png");
	}

	// 登录成功
	private void loginSuccess(String user, String pwd) {
		String getPageUrl = loginCommon(user, pwd);
		Assert.assertEquals(loginsuccessurl, getPageUrl);
		Reporter.log("用例执行完毕：用户(" + user + "/" + pwd + ")登录成功，测试通过-----------<br /><br />");
	}

	// 登录失败
	private void loginFail(String user, String pwd) {
		String getPageUrl = loginCommon(user, pwd);
		Assert.assertEquals(loginurl, getPageUrl);
		Reporter.log("用例执行完毕：用户(" + user + "/" + pwd + ")登录失败，测试通过-----------<br /><br />");
	}

	// 登录方法
	private String loginCommon(String username, String password) {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/div/form/div/table/tbody/tr[4]/td/input[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String getPageUrl = driver.getCurrentUrl();
		return getPageUrl;
	}

	@BeforeTest
	public void beforeTest() {
		driver = LocalWebDriverFactory.getBrowserDriver();
		driver.manage().window().maximize();
		driver.get(loginurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/*
	 * @AfterTest public void afterTest() { driver.quit(); }
	 */

}