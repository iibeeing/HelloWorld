package com.cglib.proxy;

public class Person {

	private String name;
	
	public void sayChinese(){
		System.out.println(" ------------ > ËµÖÐÎÄ");
	}
	
	public void sayEnglish(){
		System.out.println(" ------------ > speak English");
	}
	
	public Person(String name){
		this.name = name;
	}
}
