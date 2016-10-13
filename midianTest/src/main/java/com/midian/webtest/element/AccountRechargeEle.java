package com.midian.webtest.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountRechargeEle {
	public WebDriver driver;
	/* 右上角管理中心 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div/div[2]/span[2]/span/a[3]")
	public WebElement admcenter;

	/* 用户中心充值按钮 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/ul/li[1]/a")
	public WebElement recharge1;

	/* 确认充值按钮 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[3]/div[2]/div/div[1]/div[1]/form/div[3]/input")
	public WebElement rechargesubmit;

	/* 财务管理 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[3]/a/span")
	public WebElement Fmgt;

	/* 账户充值 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[3]/div[1]/ul/li[3]/ol/li[2]/a")
	public WebElement recharge2;

	/* 支付宝充值页面 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div/span")
	public WebElement alipaypage;

	/* 支付成功按钮 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[4]/div/div[2]/div/a[1]")
	public WebElement paysuccess;

	public AccountRechargeEle(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
