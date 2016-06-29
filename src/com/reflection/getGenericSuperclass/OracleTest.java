package com.reflection.getGenericSuperclass;

import org.junit.Test;

/**
@ClassName: OracleTest
@Description: 
getClass().getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
然后将其转换ParameterizedType。。 getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组。
[0]就是这个数组中第一个了。。 简而言之就是获得超类的泛型参数的实际类型。。
@author BEE 
@date 2016-6-29 下午3:36:25
 */
public class OracleTest {

	@Test
	public void test() {
		OptionManager manager = new OptionManager();
		manager.outputEntityClass();
	}

}
