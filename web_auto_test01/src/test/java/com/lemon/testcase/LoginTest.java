package com.lemon.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lemon.common.BaseTest;
import com.lemon.listener.TestngRetry;
import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.LoginPage;
import com.lemon.utils.Constant;
/**
 * 登录测试用例
 * @author Administrator
 *
 */
public class LoginTest extends BaseTest{
	WebDriver driver;
	//测试执行之前初始化操作
	@BeforeMethod
	public void setUpTest() {
	    //打开浏览器，访问登录地址
		driver = OpenBrower(Constant.BROWSER_TYPE, Constant.LOGIN_URL);
		//窗口最大化
		driver.manage().window().maximize();
	}
	//登录成功
	@Test()
	public void loginSuccess() throws Exception {
		//要操作哪一个页面元素 就实例化 哪一个页面page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.typeMobilephone(Constant.MOBLIEPHONE);
		loginPage.typePassword(Constant.PASSWORD);
		loginPage.clickLogin();
		//添加断言，判断是否登录成功
		//1、根据首页title判断
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), Constant.HOME_TITLE);
		//2、根据账户昵称判断
		//等待元素可见
//		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
//		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//a[contains(text(),'As')]")));
		//     //a[contains(text() + Constant.NICKNAME
//		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+Constant.NICKNAME+"')]"));
		//元素可见表示登录成功
		IndexPage indexPage = new IndexPage(driver);
		//判断元素可见
		Assert.assertTrue(indexPage.isNickNameDisplaay());
		
	}
	
	//记住手机号
	@Test()
	public void rememberPhone() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.typeMobilephone(Constant.MOBLIEPHONE);
		loginPage.typePassword(Constant.PASSWORD);
		loginPage.clickLogin();
		//添加断言，判断是否登录成功
		//1、根据首页title判断
//		String actualValue = driver.getTitle();
//		String expectValue = "前程贷官网 - 业内领先的社群互联网金融平台";
//		Assert.assertEquals(actualValue, expectValue);
		Assert.assertEquals(driver.getTitle(), Constant.LOGIN_TITLE);
		//2、根据账户昵称判断
		//等待元素可点击
//		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		//退出
		IndexPage indexPage = new IndexPage(driver);
		indexPage.clickQuit();
		Thread.sleep(2000);
		//点击登录，跳转到登录页面
		indexPage.clickLogin();
		//driver.findElement(By.xpath("//a[text()='登录']")).click();
		
		//根据元素属性获取元素值
		//String actualValue1 = driver.findElement(By.name("phone")).getAttribute("value");
		String actualValue1 = indexPage.getMoblephoneValue();
		Assert.assertEquals(actualValue1, Constant.MOBLIEPHONE);
	}
	
	//记住手机号
		@Test()
		public void forgetPhone() throws Exception {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.typeMobilephone(Constant.MOBLIEPHONE);
			loginPage.typePassword(Constant.PASSWORD);
			//取消勾选记住密码
			loginPage.clickRememberBy();
			//点击登录
			loginPage.clickLogin();
			Thread.sleep(2000);
			IndexPage indexPage = new IndexPage(driver);
			//退出登录
			indexPage.clickQuit();
			//点击登录，跳转到登录页面
			//driver.findElement(By.xpath("//a[text()='登录']")).click();
			indexPage.clickLogin();
			//根据元素属性获取元素值
			//String actualValue1 = driver.findElement(By.name("phone")).getAttribute("value");
			String actualValue1 = indexPage.getMoblephoneValue();
			String expectValue2 = "";
			System.out.println(actualValue1);
			Assert.assertEquals(actualValue1, expectValue2);
		}
	
	//登录失败用例
	@Test(dataProvider = "getLoginFailDatas01")
	public void loginFail01(String phone,String password,String expectInio) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.typeMobilephone(phone);
		loginPage.typePassword(password);
		loginPage.clickLogin();
		Assert.assertEquals(expectInio, loginPage.getCenterInfo());
				
	}
	
	@Test(dataProvider = "getLoginFailDatas02")
	public void loginFail02(String phone,String password,String expectInio) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.typeMobilephone(phone);
		loginPage.typePassword(password);
		loginPage.clickLogin();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//元素可见
//		WebElement element = wait.until(ExpectedConditions.
//				visibilityOfElementLocated(By.className("form-error-info")));
		
		String actualValue = loginPage.getInputErrorInfo();
		String expendValue = expectInio;
		Assert.assertEquals(actualValue, expendValue);
				
	}
	//数据驱动，数据提供者
	@DataProvider
	public Object[][] getLoginFailDatas01() {
		Object[][] datas = {{"15859019266","123456","此账号没有经过授权，请联系管理员!"},
				{"13709206394","LEMON666","帐号或密码错误!"},
				{"13709206394","Ab%123467","帐号或密码错误!"},
				{"13709206394","Ab%1234","帐号或密码错误!"},
				{"13709206394","Ab%1 234","帐号或密码错误!"}};
		return datas;

	}
	
	//数据驱动，数据提供者
	@DataProvider
	public Object[][] getLoginFailDatas02() {
		Object[][] datas = {{"","Ab%12345","请输入手机号"},
				{"158590192","Ab%12345","请输入正确的手机号"},
				{"1585901929292","Ab%12345","请输入正确的手机号"},
				{"1585901926%","Ab%12345","请输入正确的手机号"}};
		return datas;

	}
	
	//测试执行之后清理操作
	@AfterMethod
	public void tearDownTest() {
		driver.quit();
	}
	
}