package com.lemon.utils;
/**
 * 常量类
 * @author Administrator
 *
 */
public class Constant {
	//要打开的浏览器
    public static final String BROWSER_TYPE = "chrome";
	//host
	public static final String HOST_URL = "http://120.78.128.25:8765/";
	//登录页面地址
	public static final String LOGIN_URL = HOST_URL + "Index/login.html";
	//前程贷后台地址
	public static final String BACKSTAGE_LOGIN_URL = HOST_URL +"Admin/Index/login.html";
	
	//投资人  用户名  密码  昵称
	public static final String MOBLIEPHONE = "13709206394";
	public static final String PASSWORD = "lemon666";
	public static final String NICKNAME = "As";
	
	//借款人信息
	public static final String BORROWER = "13323234444";
	public static final String BORROWER_PWD = "lemon123456";
	
	//后台管理员  用户名  密码  万能验证码
	public static final String BACKSTAGE_ACCOUNT = "lemon7";
	public static final String BACKSTAGE_PWD = "lemonbest";
	public static final String AUTH_CODE = "hapi";
	
	//首页title
	public static final String HOME_TITLE = "前程贷官网 - 业内领先的社群互联网金融平台";
	//登录页面title
	public static final String LOGIN_TITLE = "前程贷官网 - 欢迎登录";
	//等待时间
	public static final int WAITTIME = 10;
	
	//用例最大重试次数 
	public static final int MAX_RETRY_COUNT = 2;

}
