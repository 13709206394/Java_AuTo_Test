package com.lemon.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.lemon.common.BasePage;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 后台首页page对象
 * @author Administrator
 *
 */
public class BackstageIndexPage extends BasePage{
	public BackstageIndexPage(WebDriver driver) {
		//调用父类方法 传递driver
		super(driver);
		// TODO Auto-generated constructor stub
	}
	BasePage basePage = new BasePage(driver);
	
	//借款管理
	private By loanManageBy = By.xpath("//span[text()='借款管理']");
	/**
	 * 点击借款管理
	 * @param data
	 */
	public void clickLoanManage() {
		clickElement(loanManageBy);
	}
	//iframe框架
	private By iframeBy = By.id("mainFrame");
	private By markBy = By.xpath("//span[text()='加标']");
	/**加标
	 * @param data
	 */
	public void addLoan() {
		switchIframe(iframeBy);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		clickElement(markBy);
	}
	
	private By borrowerBy = By.xpath("//input[@placeholder='输入手机号码进行查找']");
	/**
	 * 输入借款人
	 * @param data
	 * @throws Exception 
	 */
	public void typeBorrowser(String data) {
		//输入完数据后，点击键盘下键 、enter
		type(borrowerBy, data);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		typeKey(borrowerBy, Keys.ARROW_DOWN);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		typeKey(borrowerBy, Keys.ENTER);
		
	}
	
	private By loanTitleBy = By.xpath("//*[@id='add_loan']//input[@name='Title']");
	/**
	 * 输入贷款标题
	 * @param data
	 */
	public void typeLoanTitle(String data) {
		type(loanTitleBy, data);
	}
	
	private By annualRateBy = By.xpath("//input[@name='LoanRate']");
	/**
	 * 输入年利率
	 * @param data
	 */
	public void typeAnnualRate(String data) {
		type(annualRateBy, data);
	}
	
	private By loanTermBy = By.xpath("//*[@id='add_loan']//input[@name='LoanTerm']");
	/**
	 * 借款期限
	 * @param data
	 */
	public void typeLoanTerm(String data) {
		type(loanTermBy, data);
	}
	
	private By limitBy = By.xpath("//input[@name='Amount']");
	/**
	 * 借款额度
	 * @param data
	 */
	public void typeLimit(String data) {
		type(limitBy, data);
	}
	
	private By biddingDeadlineBy = By.xpath("//input[@name='BiddingDays']");
	
	/**
	 * 竞标期限
	 * @param data
	 */
	public void typeBiddingDeadline(String data) {
//		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
//		javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		type(biddingDeadlineBy, data);
		basePage.clickOnHideInput(biddingDeadlineBy,data);
	}
	
	
	private By riskManagementBy = By.xpath("//span[text()='风控评测']");
	/**
	 * 风控评测
	 * @param data
	 */
	public void clickRiskManagement() {
		basePage.clickOnHideButton(riskManagementBy);
//		clickElement(riskManagementBy);
	}
	
	private By appraisalValueBy = By.name("EvaluAmount");
	/**
	 * 评估价值
	 * 
	 */
	public void typeAppraisalValue(String data) {
		type(appraisalValueBy, data);
	}

	
	private By projectEntryBy = By.xpath("//span[text()='项目录入']");
	/**
	 * 项目录入
	 * @param data
	 */
	public void clickProjectEntry() {
//		clickElement(projectEntryBy);
		basePage.clickOnHideButton(projectEntryBy);
	}
	
	private By nativeBy = By.name("Native");
	/**
	 * 籍贯
	 * @param data
	 */
	public void typeNative(String data) {
		type(nativeBy, data);
	}
	
	private By professionBy = By.name("Profession");
	/**
	 * 职业
	 * @param data
	 */
	public void typeProfession(String data) {
		type(professionBy, data);
	}
	
	private By ageBy = By.xpath("//input[@name='Age']");
	/**
	 * 年龄
	 * @param data
	 */
	public void typeAage(String data) {
		type(ageBy, data);
	}
	
	private By submitBy = By.xpath("//span[text()='提交']");
	/**
	 * 提交
	 * @param data
	 */
	public void clickSubmit() {
		clickElement(submitBy);
	}
	
	
	//最新添加的标的位置(第一行)
	private By lastBiBy = By.id("datagrid-row-r1-1-0");
	
	public void clickLoadLocationBy() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement(lastBiBy);
	}
	
	//审核
	private By auditBy = By.xpath("//span[text()='审核']");
	
	public void clickAudit() {
		clickElement(auditBy);
	}
	
	//审核通过
	private By auditPassBy = By.xpath("//span[text()='审核通过']");
	public void auditPass() {
		clickElement(auditPassBy);
	}
	
}
