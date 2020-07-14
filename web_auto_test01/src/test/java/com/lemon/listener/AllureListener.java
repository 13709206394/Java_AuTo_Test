package com.lemon.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import com.lemon.common.BaseTest;

import io.qameta.allure.Attachment;

/**
 * 测试结果监听
 * @author Administrator
 *
 */
public class AllureListener implements IHookable{

	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		// TODO Auto-generated method stub
		//当实现了IHookable接口，run()会替换掉@Test标注的测试方法
		//1、实现IHookable接口
		//2、testNG.xml中设置监听类路径 让监听类生效
		//System.out.println("运行run()方法");
		//1、得到想要的 @Test标注的测试方法 正常执行
		//把测试结果保存在testResult
		callBack.runTestMethod(testResult);
		
		//2、判断测试用例结果是否异常
		if (testResult.getThrowable()!=null) {
			//获取当前实例对象
			BaseTest baseTest = (BaseTest) testResult.getInstance();
			WebDriver driver = baseTest.driver;
			//获取测试结果中的异常 !=null 说明存在异常
			//调用截图的接口
			TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
			//如果参数类型指定 OutputType.BYTES 截图API就返回BYTES对象
			byte[] screenShot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			//将截图添加到Allure报表
			saveScreenshot(screenShot);
		}
		
		
	}
	//@Attachment 参数value 附件名字  type 附件类型
	@Attachment(value = "Java screenshot", type = "image/png")
	public byte[] saveScreenshot(byte[] screenShot) {
	    return screenShot;
	}

}
