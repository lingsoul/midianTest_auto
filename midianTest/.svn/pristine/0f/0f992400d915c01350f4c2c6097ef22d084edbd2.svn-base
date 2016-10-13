package com.midian.webtest.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TradeRenewEle {
	public WebDriver driver;
	public Select seList1; // 域名状态下拉框
	public Select seList2; // 批量操作下拉框

	@FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "我的域名")
	public WebElement mytrade;

	/* 状态下拉框选择为可交易 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[3]/div[2]/div/form/ul/li[3]/div/select")
	public WebElement dealallow;

	/* 搜索按钮 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[3]/div[2]/div/form/ul/li[10]/div/input[2]")
	public WebElement search;

	/* 第三个域名勾选框 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[3]/div[2]/div/form/div/div[2]/table/tbody/tr[3]/td[1]/label/i")
	public WebElement tradebox1;

	/* 批量操作下拉框 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[3]/div[2]/div/form/div/div[2]/div/select")
	public WebElement opreater;

	/* 批量操作按钮 */
	@FindBy(how = How.ID, id = "multi_operater")
	public WebElement multi_operater;

	/* 确定进行续费 */
	@FindBy(how = How.XPATH, xpath = "//*[@class='elastic-footer center']/input[1]")
	public WebElement accept1;

	/* 勾选协议 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[2]/div/div[1]/form/div[1]/div/label/i")
	public WebElement checkbtn;

	/* 立即支付按钮 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[2]/div/div[2]/div/input")
	public WebElement paybtn;

	/* 续费状态 */
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[2]/div/div[2]/form/table/tbody/tr/td[4]/span")
	public WebElement renewinfo;

	/* 全页面 */
	@FindBy(how = How.XPATH, xpath = "/html")
	public WebElement newtag;

	public TradeRenewEle(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
