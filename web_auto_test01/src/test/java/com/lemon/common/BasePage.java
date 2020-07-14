package com.lemon.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lemon.utils.Constant;


/**
 * 页面类的所有公工方法
 * @author Administrator
 *
 */
public class BasePage {
	public WebDriver driver;
	//初始化日志对象
	private Logger logger = Logger.getLogger(BasePage.class);
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * 切换框架  的二次封装
	 * @param by 元素对象
	 */
	public void switchIframe(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Constant.WAITTIME);
		//等待框架可用并切换到里面去
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
	}
	
	/**
	 * 元素可见
	 * @param by 元素的by对象
	 * @return
	 */
	public WebElement waitElementVisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Constant.WAITTIME);
		//元素可见
		return wait.until(ExpectedConditions.
				visibilityOfElementLocated(by));
	}
	
	/**
	 * 元素可被点击
	 * @param by 元素的by对象吧
	 * @return
	 */
	public WebElement waitElementClick(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Constant.WAITTIME);
		//元素可见
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	/**
	 * 输入普通 数据 的二次封装
	 * @param by  元素对象
	 * @param inputDate 输入数据
	 */
	public void type(By by,String inputDate) {
		logger.info("给元素【"+by+"】输入数据【"+inputDate+"】");
		 waitElementVisible(by).sendKeys(inputDate);
		 
	}
	/**
	 * 输入按键事件的二次封装
	 * @param by 元素对象
	 * @param keys 按键事件
	 */
	public void typeKey(By by,Keys keys) {
		logger.info("给元素【"+by+"】输入按键事件【"+keys+"】");
		waitElementVisible(by).sendKeys(keys);
	}
	
	/**
	 * 点击 的二次封装
	 * @param by 元素对象
	 */
	public void clickElement(By by) {
		logger.info("点击元素【"+by+"】");
		waitElementClick(by).click();
	}
	
	/**
	 * 获取元素文本值的二次封装
	 * @param by 元素对象
	 * @return 元素文本值
	 */
	public String getElementText(By by) {
		String text = waitElementVisible(by).getText();
		logger.info("获取元素【"+by+"】文本值【"+text+"】");
		return text;
	}

	/**
	 * 获取元素属性值
	 * @param by 元素对象
	 * @param attributeName 元素属性名
	 * @return 属性值
	 */
	public String getElementValue(By by,String attributeName) {
		String value = waitElementVisible(by).getAttribute(attributeName);
		logger.info("获取元素【"+by+"】属性【"+attributeName+":"+value+"】");
		return value;
		
	}
	
	/**
	 * 元素 是否可见 二次封装
	 * @param by
	 * @return 
	 */
	public boolean visibleElement(By by) {
		boolean displayed = waitElementVisible(by).isDisplayed();
		logger.info("元素【"+by+"】是否可见:【"+displayed+"】");
		 return displayed;
	}
	
	/**
	 * 隐藏元素、不可见元素点击
	 * @param by
	 */
	public void clickOnHideButton(By by){
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(by);
		javascriptExecutor.executeScript("arguments[0].click()", element);
	}
	/**
	 * 不可见控件元素输入
	 * @param by
	 */
	public void clickOnHideInput(By by,String sendValue){
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(by);
		javascriptExecutor.executeScript("arguments[0].value=" + sendValue, element);
	}
}
