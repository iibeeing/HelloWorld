package com.hibernate.v4;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hibernate.v4.domain.User;
import com.hibernate.v4.service.UserService;

public class QueryTest {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/hibernate/v4/hiberWithTx.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		
        List<User> userList = userService.getUserList();
        List<User> userHqlList = userService.getUserListByHql();
        Integer count = userService.getRowCount();
        System.out.println("userList 's size " + count);
        System.out.println("userList is " + userList);
        System.out.println("userHqlList is " + userHqlList);
	}

}
