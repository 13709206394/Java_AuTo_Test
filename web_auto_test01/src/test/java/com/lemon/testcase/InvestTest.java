package com.lemon.testcase;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.lemon.common.BaseTest;
import com.lemon.pageobject.BackstageIndexPage;
import com.lemon.pageobject.BackstageLoginPage;
import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.LoanDetailPage;
import com.lemon.pageobject.LoginPage;
import com.lemon.utils.Constant;

/**
 * 投资测试用例类
 * @author Administrator
 *
 */
public class InvestTest extends BaseTest{
	public WebDriver driver;
	public String loanTitle = "";
	@BeforeTest
	public void setUpTest() {
		addBidData();
	}
	
	@BeforeMethod()
	public void setUpMethod() {
		//测试前置条件  登录
		//打开浏览器，访问登录地址
		driver = OpenBrower(Constant.BROWSER_TYPE, Constant.LOGIN_URL);
		//窗口最大化
		driver.manage().window().maximize();
		//实例化登录页面对象
		LoginPage loginPage = new LoginPage(driver);
		//输入用户名
		loginPage.typeMobilephone(Constant.MOBLIEPHONE);
		//输入密码
		loginPage.typePassword(Constant.PASSWORD);
		//点击登录按钮，登录
		loginPage.clickLogin();
	}
	@Test
	public void testInvest01() {
		//选择标进行投资
		//创建测试数据方式 1、通过接口创建数据 (执行速度适中 保证数据是正确的)
		//2、通过数据库insert操作（执行速度快，表关联性强时不能保证插入的数据是正确的）
		//3、通过UI界面操作（符合业务，缺点不稳定，执行速度慢）
		//span[contains(text(),'殇1593930305106')]/ancestor::a[@title='点击查看标详情']/following-sibling::div[@class='b-body clearfix']//a[text()='抢投标']
//		"//span[contains(text(),'"+loanTitle+"')]/ancestor::a[@title='点击查看标详情']/following-sibling::div[@class='b-body clearfix']//a[text()='抢投标']
		
		IndexPage indexPage = new IndexPage(driver);
		//点击抢投标
		indexPage.clickRushToBid(loanTitle);
		//输入投资金额
		LoanDetailPage loanDetailPage = new LoanDetailPage(driver);
		loanDetailPage.typeinvestAmount(200.00);
		//点击投资
		loanDetailPage.clickInvestButton();
		//判断投资是否成功
		assertTrue(loanDetailPage.isInvestSuccessShow());
	}
	
	//创建标的测试数据
	public void addBidData() {
		//打开浏览器，访问登录地址
		driver = OpenBrower(Constant.BROWSER_TYPE, Constant.BACKSTAGE_LOGIN_URL);
		//窗口最大化
		driver.manage().window().maximize();
		//后台登录
		BackstageLoginPage loginPage = new BackstageLoginPage(driver);
		loginPage.typeAccount(Constant.BACKSTAGE_ACCOUNT);
		loginPage.typePassword(Constant.BACKSTAGE_PWD);
		loginPage.typeVerifyCode(Constant.AUTH_CODE);
		loginPage.clickLogin();
		
		//后台页面加标
		BackstageIndexPage indexPage = new BackstageIndexPage(driver);
		//点击借款管理
		indexPage.clickLoanManage();
		//点击加标
		indexPage.addLoan();
		//输入借款人
		indexPage.typeBorrowser(Constant.BORROWER);
		//系统当前时间戳  long类型
		long timeVar = System.currentTimeMillis();
		loanTitle = "殇" + timeVar;
		//输入贷款标题  不唯一
		indexPage.typeLoanTitle(loanTitle);
		//输入年利率
		indexPage.typeAnnualRate("18");
		//输入借款期限
		indexPage.typeLoanTerm("3");
		//输入借款额度
		indexPage.typeLimit("180000");
		//输入竞标期限
		indexPage.typeBiddingDeadline("7");
		//点击风控评测
		indexPage.clickRiskManagement();
		//评估价值
		indexPage.typeAppraisalValue("2000000");
		//项目录入
		indexPage.clickProjectEntry();
		//籍贯
		indexPage.typeNative("湖南");
		//职业
		indexPage.typeProfession("法师");
		//年龄
		indexPage.typeAage("28");
		//提交
		indexPage.clickSubmit();
		
		//标的三次审核
		for (int i = 0; i < 3; i++) {
			indexPage.clickLoadLocationBy();
			indexPage.clickAudit();
			indexPage.auditPass();
		}
	}
	
	@AfterMethod
	public void tearDownTest() {
		driver.quit();
	}
}
