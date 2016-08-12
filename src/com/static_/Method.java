package com.static_;

public class Method {
	public static String publicstaticmethod;

	public String publicmethod;

	private String privatemethod;

	String defaultmethod;

	public static String getPublicstaticmethod() {
		return publicstaticmethod;
	}

	public static void setPublicstaticmethod(String publicstaticmethod) {
		Method.publicstaticmethod = publicstaticmethod;
	}

	public String getPublicmethod() {
		return publicmethod;
	}

	public void setPublicmethod(String publicmethod) {
		this.publicmethod = publicmethod;
	}

	public String getPrivatemethod() {
		return privatemethod;
	}

	public void setPrivatemethod(String privatemethod) {
		this.privatemethod = privatemethod;
	}

	public String getDefaultmethod() {
		return defaultmethod;
	}

	public void setDefaultmethod(String defaultmethod) {
		this.defaultmethod = defaultmethod;
	}
	
	
}
