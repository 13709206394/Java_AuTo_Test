package com.lemon.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{
	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		//得到@test注解对应的 retryAnalyzer对象
		IRetryAnalyzer iAnalyzer = annotation.getRetryAnalyzer();
		if (iAnalyzer == null) {
			//@test注解的retryAnalyzer 属性为空 就进行设置
			annotation.setRetryAnalyzer(TestngRetry.class);
		}
		  }
	
	

}
