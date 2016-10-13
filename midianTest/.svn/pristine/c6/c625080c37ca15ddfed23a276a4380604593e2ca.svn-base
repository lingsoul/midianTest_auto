package com.midian.webtest.use;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.midian.webtest.core.LocalWebDriverFactory;
import com.midian.webtest.dataprovider.MidianInfo;
import com.midian.webtest.dataprovider.UseCookiesLoginBatch;
import com.midian.webtest.element.AccountRechargeEle;

public class AccountRecharge {
	public WebDriver driver;

	@Test
	// 管理中心-账户充值
	public void accountRecharge1() {
		AccountRechargeEle rechargeele = new AccountRechargeEle(driver);
		rechargeele.admcenter.click();
		rechargeele.recharge1.click();
		rechargeele.rechargesubmit.click();
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄

		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			driver.switchTo().window(it.next());// 切换到新窗口
			Assert.assertEquals(rechargeele.alipaypage.getText(), "你好，欢迎使用支付宝付款！");
			// System.out.println("New page title is:" + driver.getTitle());
			driver.close();// 关闭新窗口
		}
		driver.switchTo().window(currentWindow);// 回到原来页面
		rechargeele.paysuccess.click();

	}

	// 财务管理-账户充值
	@Test(dependsOnMethods = "accountRecharge1")
	public void accountRecharge2() {
		AccountRechargeEle rechargeele = new AccountRechargeEle(driver);
		driver.get(MidianInfo.IndexURL);
		rechargeele.admcenter.click();
		rechargeele.Fmgt.click();
		rechargeele.recharge2.click();
		rechargeele.rechargesubmit.click();
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄

		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			driver.switchTo().window(it.next());// 切换到新窗口
			Assert.assertEquals(rechargeele.alipaypage.getText(), "你好，欢迎使用支付宝付款！");
			// System.out.println("New page title is:" + driver.getTitle());
			driver.close();// 关闭新窗口
		}
		driver.switchTo().window(currentWindow);// 回到原来页面
		rechargeele.paysuccess.click();
	}

	// 显性等待：等待waittime秒内未查询到内容，执行失败
	public void waitfortxt(WebDriver driver, Integer waittime, final String waittxt) {
		WebDriverWait waitlogin = new WebDriverWait(driver, waittime);
		waitlogin.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.linkText(waittxt));
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

	/*
	 * //在当前浏览器打开新标签 traderegele.newtag.sendKeys(Keys.CONTROL + "t");
	 * driver.get(url);
	 */

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