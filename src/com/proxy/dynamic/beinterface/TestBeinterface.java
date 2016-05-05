package com.proxy.dynamic.beinterface;

import org.junit.Test;

public class TestBeinterface {

	@Test
	public void test() {
		Subject proxy = DynProxyFactory.getInstance();
		proxy.dealTask("DBQueryTask");
	}

}
