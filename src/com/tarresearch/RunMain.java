package com.tarresearch;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RunMain {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		try {
/*			Class<TarResearch> userClass = TarResearch.class;
			TarResearch tarResearch = new TarResearch();
			Field[] field = userClass.getDeclaredFields();
			//Method[] methods = userClass.getMethods();
			//System.out.println("methods len " + methods.length);
			for (int i = 0; i < field.length; i++) {
				if (field[i].getAnnotation(IgnoreProperty.class) != null) {
					continue;
				}
				String fie = field[i].getName().substring(0, 1).toUpperCase() + field[i].getName().substring(1);
				Method method = userClass.getMethod("get" + fie,new Class[]{});
				//Method method = methods[i];
				Object obj = method.invoke(tarResearch,null);
				if (obj == null) {
					System.out.println("数据错误");
				}else{
					System.out.println(obj.toString());
				}
			}*/
			String str = "BbIDc4HcGgYfJAfVsP+M2w==";
			if(str.equals("BbIDc4HcGgYfJAfVsP+M2w==")){
				System.out.println("OK");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
