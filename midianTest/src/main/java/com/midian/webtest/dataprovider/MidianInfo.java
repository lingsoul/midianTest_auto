/**
 * Copyright @ 2016jkzl. All rights reserved
 */
package com.midian.webtest.dataprovider;

/**
 * @author peter.Chen
 * @version 1.0
 *          <p>
 *          operation date operator content 2016/9/8 15:47 peter.Chen new
 * @Description:
 * @date 2016/9/8 15:47
 */
public class MidianInfo {
	/*测试环境参数*/
	
	public static String IndexURL = 
			ExcelData.getData("MidianTest",2)[0][0].toString();
	public static String username = 
			ExcelData.getData("MidianTest",3)[0][0].toString();
	public static String password = 
			ExcelData.getData("MidianTest",4)[0][0].toString();
	public static String answer = 
			ExcelData.getData("MidianTest",5)[0][0].toString();
	public static String RegTrade = 
			ExcelData.getData("MidianTest",6)[0][0].toString();
	public static String cookiestype = 
			ExcelData.getData("MidianTest",7)[0][0].toString();
	
/*	正式环境参数
	
	public static String IndexURL = 
			ExcelData.getData("MidianFormal",2)[0][0].toString();
	public static String username = 
			ExcelData.getData("MidianFormal",3)[0][0].toString();
	public static String password = 
			ExcelData.getData("MidianFormal",4)[0][0].toString();
	public static String answer = 
			ExcelData.getData("MidianFormal",5)[0][0].toString();
	public static String RegTrade = 
			ExcelData.getData("MidianFormal",6)[0][0].toString();
	public static String cookiestype = 
			ExcelData.getData("MidianTest",7)[0][0].toString();*/
	
	
}
