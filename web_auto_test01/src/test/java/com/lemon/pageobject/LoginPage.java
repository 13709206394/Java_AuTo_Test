package com.lemon.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lemon.common.BasePage;
/**
 * 登录页面类
 * @author Administrator
 *
 */
public class LoginPage extends BasePage{
	//调用父类驱动
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private WebDriver driver;
	
	//将  定位方式 + 定位表达式（值） = 属性描述  看成一个对象  类型是By
	private By mobilephoneBy = By.name("phone");
	private By passwordBy = By.name("password");
	private By loginBy = By.xpath("//button[text()='登录']");
	private By logoutBy = By.xpath("//a[text()='退出']");
	
	//记住手机号
	private By rememberBy = By.name("remember_me");
	
	//登录页面中间的错误提示信息
	private By centerErrorInfoBy = By.className("layui-layer-content");
	
	//输入框的错误提示信息
	private By inputErrorInfoBy = By.className("form-error-info");
	
	/**
	 * 操作元素的方法
	 * @param data  输入手机号
	 */
	public void typeMobilephone(String data) {
		//驱动有谁提供  ？？ 由调用方提供
//		waitElementVisible(mobilephoneBy).sendKeys(data);
		type(mobilephoneBy, data);
	}
	
	/**
	 * 操作元素的方法
	 * @param data 输入密码
	 */
	public void typePassword(String data) {
//		waitElementVisible(passwordBy).sendKeys(data);
		type(passwordBy, data);
	}
	
	/**
	 * 操作元素的方法,登录
	 *
	 */
	public void clickLogin() {
//		waitElementVisible(loginBy).click();
		clickElement(loginBy);
	}

	/**
	 * 退出登录
	 */
	public void logOut() {
//		waitElementClick(logoutBy).click();
		clickElement(logoutBy);
	}

	/**
	 * 等待提示信息出现
	 * @return
	 */
	public String getCenterInfo() {
//		return waitElementVisible(centerErrorInfoBy).getText();
		return getElementText(centerErrorInfoBy);

	}
	
	/**
	 * 等待输入框错误提示信息出现
	 * @return
	 */
	public String getInputErrorInfo() {

//		return waitElementVisible(inputErrorInfoBy).getText();
		return getElementText(inputErrorInfoBy);
	}
	/**
	 * 取消记住我的手机号
	 */
	public void clickRememberBy() {
//		waitElementClick(rememberBy).click();
		clickElement(rememberBy);
	}
}
