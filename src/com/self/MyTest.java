package com.self;

import com.self.EnumTest.TrafficLamp;

@MyAnnotation(hello = "beijing", world = "shanghai", array = {}, lamp = TrafficLamp.RED, style = int.class)
public class MyTest {
	@MyAnnotation(lannotation = @TestAnnotation(value = "baby"), world = "shanghai", array = {
			1, 2, 3 }, lamp = TrafficLamp.YELLOW)
	@Deprecated
	@SuppressWarnings("")
	public void output() {
		System.out.println("output something!");
	}
}
