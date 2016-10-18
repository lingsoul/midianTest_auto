package com.midian.webtest.use;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.midian.webtest.core.LocalWebDriverFactory;
import com.midian.webtest.dataprovider.UseCookiesLoginBatch;
import com.midian.webtest.element.AuctionPublishEle;
import com.midian.webtest.element.FixedPricePublishEle;
import com.midian.webtest.utils.SnapShot;

public class PublishAuctionAndFixed {
	public WebDriver driver;

	@Parameters({"answer"})
	@Test
	// (dataProvider = "getUrlInfoArray", dataProviderClass =
	// DataProviderConf.class)
	// 自动发布一口价
	public void publishFixedPrice(String answer) {

		Reporter.log("--------------开始执行publishFixedPrice()-------------<br />");
		Reporter.log("开始执行用例：" + "发布一口价-----------<br />");
		FixedPricePublishEle fixedfriceele = new FixedPricePublishEle(driver);
		fixedfriceele.mytrade.click();
		fixedfriceele.seList1 = new Select(fixedfriceele.dealallow);
		fixedfriceele.seList1.selectByVisibleText("可交易");
		fixedfriceele.search.click();
		Reporter.log("--------------可交易域名查询成功！-------------<br />");
		waitfortxt(driver, 3, "续费");
		fixedfriceele.tradebox1.click();
		fixedfriceele.seList2 = new Select(fixedfriceele.opreater);
		fixedfriceele.seList2.selectByVisibleText("发布交易");
		Reporter.log("--------------进行发布一口价域名交易！-------------<br />");
		fixedfriceele.multi_operater.click();
		// 点击确定后，发布一口价
		waitofimplicitly(10);
		fixedfriceele.accept1.click();
		waitofimplicitly(10);
		fixedfriceele.FixedPricebtn.click();
		// 全选域名
		waitofimplicitly(10);
		fixedfriceele.checkall.click();
		// 发布信息：5天、价格为666、简介为“自动发布一口价”
		fixedfriceele.seList3 = new Select(fixedfriceele.endtime1);
		fixedfriceele.seList3.selectByVisibleText("5天");
		fixedfriceele.tradeprice1.sendKeys("666");
		fixedfriceele.infotxt1.sendKeys("自动发布一口价");
		Reporter.log("--------------填写一口价域名交易信息成功！-------------<br />");
		fixedfriceele.nextstepbtn.click();
		waitofimplicitly(10);
		// 点击交易款可提现
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fixedfriceele.ktxbtn);
		// 找到该页面元素后直接发送一条Click的JavaScript指令
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fixedfriceele.agreebox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fixedfriceele.submit);
		// 输入安全校验答案，点击确定
		waitofimplicitly(10);
		fixedfriceele.answertxt.sendKeys(answer);
		fixedfriceele.confirm.click();
		// 判断是否发布成功
		waitofimplicitly(10);
		Assert.assertEquals(fixedfriceele.tradestatus.getText(), "发布成功！");
		waitmsec(300);
		snapshut("发布一口价结果");
		Reporter.log("--------------发布一口价结果截图成功！-------------<br />");

	}

	@Parameters({"indexURL","answer"})
	@Test(dependsOnMethods = "publishFixedPrice")
	// ,dataProvider = "getUrlInfoArray", dataProviderClass =
	// DataProviderConf.class
	// 发布自动拍卖
	public void publishAuction(String indexURL,String answer) {
		Reporter.log("--------------开始执行publishAuction()-------------<br />");
		Reporter.log("开始执行用例：" + "发布拍卖-----------<br />");
		AuctionPublishEle auctionele = new AuctionPublishEle(driver);
		driver.get(indexURL);
		auctionele.mytrade.click();
		auctionele.seList1 = new Select(auctionele.dealallow);
		auctionele.seList1.selectByVisibleText("可交易");
		auctionele.search.click();
		Reporter.log("--------------可交易域名查询成功！-------------<br />");
		auctionele.tradebox1.click();
		auctionele.seList2 = new Select(auctionele.opreater);
		auctionele.seList2.selectByVisibleText("发布交易");
		Reporter.log("--------------进行发布域名拍卖交易！-------------<br />");
		auctionele.multi_operater.click();
		// 点击确定后，发布一口价
		waitofimplicitly(10);
		auctionele.accept1.click();
		waitofimplicitly(10);
		auctionele.auctionbtn.click();
		// 全选域名
		waitofimplicitly(10);
		auctionele.checkall.click();
		// 发布信息
		auctionele.seList3 = new Select(auctionele.endtime1);
		auctionele.seList3.selectByVisibleText("5天");
		auctionele.tradeprice1.sendKeys("888");
		auctionele.infotxt1.sendKeys("自动发布拍卖");
		Reporter.log("--------------填写域名拍卖交易信息成功！-------------<br />");
		auctionele.nextstepbtn.click();
		waitofimplicitly(10);
		// 点击交易款可提现
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", auctionele.ktxbtn);
		// 找到该页面元素后直接发送一条Click的JavaScript指令
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", auctionele.agreebox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", auctionele.submit);
		// 输入安全校验答案，点击确定
		waitofimplicitly(10);
		auctionele.answertxt.sendKeys(answer);
		auctionele.confirm.click();
		// 判断是否发布成功
		waitofimplicitly(10);
		Assert.assertEquals(auctionele.tradestatus.getText(), "发布成功！");
		waitmsec(300);
		snapshut("发布拍卖结果");
		Reporter.log("--------------发布域名拍卖结果截图成功！-------------<br />");
	}

	// 等待waittime秒内未查询到内容，执行失败
	public void waitfortxt(WebDriver driver, Integer waittime, final String waittxt) {
		WebDriverWait waitlogin = new WebDriverWait(driver, waittime);
		waitlogin.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.linkText(waittxt));
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

	@Parameters({"indexURL","cookiesType"})
	@BeforeTest
	public void beforeTest(String indexURL,String cookiesType) {
		driver = LocalWebDriverFactory.getBrowserDriver();
		driver.manage().window().maximize();
		// driver.get(beforeurl);
		driver.get(indexURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("------------开始读取用户缓存信息-----------<br />");
		// 读入用户登录缓存信息
		UseCookiesLoginBatch cookieslogin = new UseCookiesLoginBatch(driver);
		cookieslogin.useCookiesLoginBatch(cookiesType);
		driver.get(indexURL);
		Reporter.log("------------读入缓存成功，开始执行publishFixedPrice()-----------<br />");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}