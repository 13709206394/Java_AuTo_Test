package com.lemon.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lemon.common.BasePage;

/**
 * 后台管理系统 对象类
 * @author Administrator
 *
 */
public class BackstageLoginPage extends BasePage{
	//调用父类构造方法中的驱动
	public BackstageLoginPage(WebDriver driver) {
		super(driver);
	}
	//后台管理系统用户名对象
	private By accountBy = By.name("admin_name");
	//后台管理系统密码对象
	private By passwordBy = By.name("admin_pwd");
	//后台管理系统验证码对象
	private By verifyCodeBy = By.xpath("//input[@class='admin_login_verify']");
	//登录对象
	private By loginBy = By.xpath("//button[text()='登陆后台']");
	
	/**
	 * 输入用户名
	 * @param data
	 */
	public void typeAccount(String data) {
		type(accountBy, data);
	}
	/**
	 * 密码
	 * @param data
	 */
	public void typePassword(String data) {
		type(passwordBy, data);
	}
	/**
	 * 输入验证码
	 * @param data
	 */
	public void typeVerifyCode(String data) {
		type(verifyCodeBy, data);
		
	}
	/**
	 * 点击登录
	 */
	public void clickLogin() {
		clickElement(loginBy);
	}

}
