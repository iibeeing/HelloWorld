package com.static_;

public class Name {

	public static String publicstaticname;
	
	public String publicname;
	
	private String privatename;
	
	String defaultname;

	public static String getPublicstaticname() {
		return publicstaticname;
	}

	public static void setPublicstaticname(String publicstaticname) {
		Name.publicstaticname = publicstaticname;
	}

	public String getPublicname() {
		return publicname;
	}

	public void setPublicname(String publicname) {
		this.publicname = publicname;
	}

	public String getPrivatename() {
		return privatename;
	}

	public void setPrivatename(String privatename) {
		this.privatename = privatename;
	}

	public String getDefaultname() {
		return defaultname;
	}

	public void setDefaultname(String defaultname) {
		this.defaultname = defaultname;
	}

	
}
