package com.midian.webtest.use;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.midian.webtest.core.LocalWebDriverFactory;
import com.midian.webtest.dataprovider.MidianInfo;
import com.midian.webtest.dataprovider.UseCookiesLoginBatch;
import com.midian.webtest.element.TradeRegEle;
import com.midian.webtest.utils.SnapShot;

public class TradeRegister {
	public static WebDriver driver;

	// @Test(dataProvider = "GetDataFromXml", dataProviderClass =
	// ExcelDataProvider.class)
	@Test
	public void tradeRegister() {
		TradeRegEle traderegele = new TradeRegEle(driver);
		traderegele.regbtn.click();
		traderegele.tradeinput.sendKeys(MidianInfo.RegTrade);
		traderegele.combtn.click();
		traderegele.vipbtn.click();
		traderegele.checkbtn.click();
		waitforxpath(driver, 60, "/html/body/div[1]/div[2]/div[2]/form/table/tbody/tr/td[5]/input");
		Reporter.log("查询域名成功，进入注册页面-----------<br />");
		traderegele.selectall.click();
		traderegele.batchbtn.click();
		waitforxpath(driver, 30, "/html/body/div[1]/div[2]/div/div[1]/form/div[1]/div/label/i");
		traderegele.acceptbtn.click();
		traderegele.submitbtn.click();
		waitforxpath(driver, 60, "/html/body/div[1]/div[2]/div/div[2]/form/div/span");
		Assert.assertEquals(traderegele.reginfo.getText(), "注册成功");
		Reporter.log("域名" + MidianInfo.RegTrade + "注册成功！-----------<br />");

	}

	// 显性等待：等待waittime内未定位到xpath元素，执行失败
	public void waitforxpath(WebDriver driver, Integer waittime, final String locationxpath) {
		WebDriverWait waitlogin = new WebDriverWait(driver, waittime);
		waitlogin.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.xpath(locationxpath));
			}
		});
	}

	// 隐性等待：
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

	@BeforeTest
	public void beforeTest() {
		driver = LocalWebDriverFactory.getBrowserDriver();
		driver.manage().window().maximize();
		driver.get(MidianInfo.IndexURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 读入用户登录缓存信息
		UseCookiesLoginBatch cookieslogin = new UseCookiesLoginBatch(driver);
		cookieslogin.useCookiesLoginBatch(MidianInfo.cookiestype);
		driver.get(MidianInfo.IndexURL);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
