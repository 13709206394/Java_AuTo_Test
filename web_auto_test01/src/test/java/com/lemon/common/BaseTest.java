package com.lemon.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
/**
 * 打开浏览器
 * @author Administrator
 *
 */
public class BaseTest {
	//创建log4j日志对象
	private Logger logger = Logger.getLogger(BaseTest.class);
	public WebDriver driver;
	
	public WebDriver OpenBrower(String browser,String url) {
		  if (browser.equals("IE")) {
		   //3、打开IE浏览器
		   //设置火狐浏览器路径
		   System.setProperty("webdriver.ie.bin", 
		     "C:\\Program Files\\Internet Explorer\\iexplore.exe");
		   //设置驱动路径
		   System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
		   //浏览器缩放设置1、手动设置到100% 2、通过代码 代码忽略缩放设置
		   DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		   desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		   //取消IE安全设置（忽略IE的Protected Mode的设置） DesiredCapabilities capabilities = new DesiredCapabilities(); 
		   desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		   InternetExplorerDriver iEDriver = new InternetExplorerDriver(desiredCapabilities);
		   iEDriver.get(url);
		   driver = iEDriver;
		   logger.info("打开ie浏览器");
		   return iEDriver;
		  }else if (browser.equals("chrome")) {
		   //1、打开谷歌浏览器
		   //设置浏览器驱动地址
		   System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		   //打开Chrome-实例化Chromedrive
		   //Chrome 支持 无头浏览器模式  在后台运行 ，火狐、IE不支持
		   ChromeOptions chromeOptions = new ChromeOptions();
		   chromeOptions.addArguments("--headless");
		   ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
		   chromeDriver.get(url);
		   driver = chromeDriver;
		   logger.info("打开Chrome浏览器");
		   return chromeDriver;
		  }else if (browser.equals("firefox")) {
		   //2、打开谷歌火狐浏览器
		   //设置火狐浏览器路径
		   System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Firefox\\firefox.exe");
		   //设置驱动路径
		   System.setProperty("webdriver.firefox.driver", "src/test/resources/geckodriver.exe");
		   FirefoxDriver firefoxDriver = new FirefoxDriver();
		   //Cannot find firefox binary in PATH. Make sure firefox is installed
		   driver = firefoxDriver;
		   logger.info("打开firefox浏览器");
		   firefoxDriver.get(url);
		   return firefoxDriver;
		  }
		  return null;
		 }
	

}
