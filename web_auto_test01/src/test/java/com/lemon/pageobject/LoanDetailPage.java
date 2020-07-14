package com.lemon.pageobject;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lemon.common.BasePage;

/**
 * 投资页面
 * @author Administrator
 *
 */
public class LoanDetailPage extends BasePage{
	public LoanDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//投资金额输入框
	private By investAmountInputBy = By.xpath("//input[@data-url='/Invest/invest']");
	//投资按钮
	private By investButtonBy = By.xpath("//button[text()='投标']");
	//投标成功文本元素
	private By investSuccessBy = By.xpath("//div[text()='投标成功！']");
	
	
	/**
	 * 输入投资金额
	 * @param inputDate
	 */
	public void typeinvestAmount(Double inputDate) {
		type(investAmountInputBy, inputDate+"");
	}
	
	/**
	 * 点击投资
	 * @param
	 */
	public void clickInvestButton() {
		clickElement(investButtonBy);
	}
	
	/**
	 * 投资是否成功
	 * @param
	 * @return 
	 */
	public boolean isInvestSuccessShow() {
		return visibleElement(investSuccessBy);
	}

}
