package com.lemon.testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.lemon.common.BaseTest;
import com.lemon.utils.Constant;

/**
 * 截图测试
 * @author Administrator
 *
 */
public class ScreenshotTest {
	public static void main(String[] args) {
		BaseTest baseTest = new BaseTest();
		WebDriver driver = baseTest.OpenBrower(Constant.BROWSER_TYPE, Constant.BACKSTAGE_LOGIN_URL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//调用截图的接口
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		//参数表示截图类型
		//如果参数类型指定 OutputType.FILE 截图API就返回FILE对象
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		//如果参数类型指定 OutputType.BYTES 截图API就返回BYTES对象
		byte[] screenshotAs = takesScreenshot.getScreenshotAs(OutputType.BYTES);
		//把file截图保存在本地  以.jpg或.png结尾
		//把原始FILE对象拷贝到目标FILE对象（本地 FILE对象（文件）中）
		File targetFile = new File("D:\\lemontest\\test.jpg");
		
		//调用第三方依赖 commons.io  maven 中导入依赖
		try {
			FileUtils.copyFile(srcFile, targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//用例执行失败的时候截图
		
		
		
		
		
	}

}
