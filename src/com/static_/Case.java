package com.static_;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class Case {

	/**
	@Description: TODO(这里用一句话描述这个方法的作用)
	@param @param args    设定文件
	@date 创建时间：2016-8-11 下午4:48:13 
	@version 1.0
	@return void    返回类型
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Name.setPublicstaticname("1");
		System.out.println(Name.getPublicstaticname());
		
		
		Method.setPublicstaticmethod("2");
		System.out.println(Method.getPublicstaticmethod());
		
		Name name = new Name();
		Case caseone = new Case();
		
		System.out.println(SingletonClass.getInstance().toString());
		System.out.println(SingletonClass.getInstance().toString());
		
		
	}

}
