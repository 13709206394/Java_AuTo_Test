package com.lemon.pageobject;
/**
 * 首页页面对象
 * @author Administrator
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lemon.common.BasePage;
import com.lemon.utils.Constant;

public class IndexPage extends BasePage{
	WebDriver driver;
	//退出登录
	private By quitBy = By.xpath("//a[text()='退出']");
	//首页的登录
	private By loginBy = By.xpath("//a[text()='登录']");
	
	//登录页面手机号码文本框
	private By monlephoneBy = By.name("phone");
	
	//用户昵称的By对象
	private By nickBy = By.xpath("//a[contains(text(),'"+Constant.NICKNAME+"')]");

	//调用构造方法，传递驱动
	public IndexPage(WebDriver driver) {
		super(driver);
	}
	//退出登录操作
	public void clickQuit() {
//		waitElementClick(quitBy).click();
		clickElement(quitBy);
	}
	//点击登录，跳转到登录页面
	public void clickLogin() {
//		waitElementClick(loginBy).click();
		clickElement(loginBy);
		
	
	}
	
	//获取登录页面手机号码
	public String getMoblephoneValue() {
//		return waitElementVisible(monlephoneBy).getAttribute("value");
		return getElementValue(monlephoneBy, "value");
		
	}
	
	//等待昵称可见
	public boolean isNickNameDisplaay() {
		//等待元素可见
//		return waitElementVisible(nickBy).isDisplayed();
		return visibleElement(nickBy);
	}
	
	//点击抢投标
	public void clickRushToBid(String loanTitle) {
		clickElement(By.xpath("//span[contains(text(),'"+loanTitle+"')]/ancestor::a[@title='点击查看标详情']/following-sibling::div[@class='b-body clearfix']//a[text()='抢投标']"));
	}
}
