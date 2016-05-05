package com.proxy.dynamic.notinterface;

import java.lang.reflect.Proxy;
import org.junit.Test;

public class UserServiceTest {

	@Test
	public void test() {
		// fail("Not yet implemented");
		IUserDAO userDAO = new UserDAOImpl(); 
		// Ҫʹ�ö�̬��������Ҫ��newһ��������Ķ���Ҫ��Ȼ�������ʲô�أ��԰ɣ�
		UserDAOProxy uDaoProxy = new UserDAOProxy(); 
		// ʹ�ö�̬����ҲҪnewһ��������Ҫ��ɵ�ҵ���߼�
		uDaoProxy.setTarget(userDAO); 
		// �ⲽ���ǰ󶨣�������Ҫ�Ķ�����ɵĶ����뱻���������ϵ����

		IUserDAO userDAOProxy = (IUserDAO) Proxy.newProxyInstance(userDAO.getClass().getClassLoader(), userDAO.getClass().getInterfaces(), uDaoProxy); 
		/* �ⲽ�Ǵ�����������ˣ���һ������ָ���������:ʹ������������ܷ��ʱ��������
		�ڶ�������ָ��������Ӧ�þ�����Щ�ӿڣ�Ҫ��Ȼ��ôȥ����������󣨱���������������ģ�
		�����ҲӦ������ɣ��Բ��ԣ������ڶ�����������ָ����������������ɵ�ҵ���߼��ˣ���ǰ�������Ļ�ȡ���������ִ��ʱ�䡣*/
		userDAOProxy.save(new User()); 
		// ���ʹ�ô���������б������������з����������㻹�����ڱ��������ķ���ִ��ǰ��ִ�к���϶����ҵ���߼���
	}

}
