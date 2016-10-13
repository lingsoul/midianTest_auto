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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.midian.webtest.core.LocalWebDriverFactory;
import com.midian.webtest.dataprovider.MidianInfo;
import com.midian.webtest.dataprovider.UseCookiesLoginBatch;
import com.midian.webtest.element.TradeRenewEle;
import com.midian.webtest.utils.SnapShot;

public class TradeRenew {
	public static WebDriver driver;

	// @Test(dataProvider = "GetDataFromXml", dataProviderClass =
	// ExcelDataProvider.class)
	@Test
	public void tradeRenew() {
		TradeRenewEle traderenewele = new TradeRenewEle(driver);
		traderenewele.mytrade.click();
		traderenewele.seList1 = new Select(traderenewele.dealallow);
		traderenewele.seList1.selectByVisibleText("可交易");
		traderenewele.search.click();
		Reporter.log("--------------可交易域名查询成功！-------------<br />");
		traderenewele.tradebox1.click();
		traderenewele.seList2 = new Select(traderenewele.opreater);
		traderenewele.seList2.selectByVisibleText("批量续费");
		Reporter.log("--------------进行域名续费！-------------<br />");
		traderenewele.multi_operater.click();
		traderenewele.accept1.click();
		traderenewele.checkbtn.click();
		traderenewele.paybtn.click();
		waitforxpath(driver, 60, "/html/body/div[1]/div[2]/div/div[2]/form/div/span");
		Assert.assertEquals(traderenewele.renewinfo.getText(), "续费成功");
		Reporter.log("--------------域名续费成功！-----------<br />");

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
