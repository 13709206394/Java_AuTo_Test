package com.lemon.listener;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
/**
 * TestListenerAdapter 储存用例结果信息
 * @author Administrator
 *
 */
public class TestResultListener extends TestListenerAdapter{
	private Logger logger = Logger.getLogger(TestResultListener.class);
	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
//		System.out.println("当前用例执行成功");
		TestngRetry.currentRetryCount=1;
		logger.info("当前用例执行成功");
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailure(tr);
//		System.out.println("当前用例执行失败");
		TestngRetry.currentRetryCount=1;
		logger.info("当前用例执行失败");
		
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSkipped(tr);
		System.out.println("当前用例跳过");
	}

}
