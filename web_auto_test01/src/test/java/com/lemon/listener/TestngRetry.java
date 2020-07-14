package com.lemon.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.IFactoryAnnotation;

import com.lemon.utils.Constant;

public class TestngRetry implements IRetryAnalyzer{
	private static Logger logger = Logger.getLogger(TestngRetry.class);
	//当前用例重复次数
	public static int currentRetryCount = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		if (currentRetryCount <= Constant.MAX_RETRY_COUNT) {
			logger.info("开始第"+"【"+currentRetryCount+"】次重试");
			currentRetryCount++;
			return true;
		}
		// TODO Auto-generated method stub
		//返回false 那么TestNG在执行TestCase失败的话，会检测到这个状态，就不会运行重试机制
		//返回true ,那么TestNG在执行TestCase失败的话，会检测到这个状态，就会运行重试机制
		return false;
		
		
	}

}
