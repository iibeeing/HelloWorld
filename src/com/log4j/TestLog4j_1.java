package com.log4j;

import org.apache.log4j.Logger;

public class TestLog4j_1 {

	/**
	@Description: TODO(这里用一句话描述这个方法的作用)
	@param @param args    设定文件
	@date 创建时间：2016-5-13 下午5:07:10 
	@version 1.0
	@return void    返回类型
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(TestLog4j_1.class);  
        logger.info("zhujiadun");  
        logger.info("在测试log4j配置stdout");
        try{
        	int n = 10 / 0;
        	logger.info("n is " + n);
        }catch (Exception e) {
        	e.printStackTrace();
        	logger.error("e is " + e.getMessage());
		}
	}

}
