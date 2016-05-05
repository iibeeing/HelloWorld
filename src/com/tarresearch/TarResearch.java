package com.tarresearch;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TarResearch implements Serializable {
	private String id;
	
	private Integer serialVersionUID = 1;
	 
	 @IgnoreProperty
	private  Integer researchId;
	 
/*	 @IgnoreProperty
	 private TarUser userId;*/
	 
	 private String version;
	 
	 private String grade;

	public String getId() {
		System.out.println("getId is used");
		return id;
	}

	public void setId(String id) {
		System.out.println("setId is used");
		this.id = id;
	}

	public Integer getSerialVersionUID() {
		System.out.println("getSerialVersionUID is used");
		return serialVersionUID;
	}

	public void setSerialVersionUID(Integer serialVersionUID) {
		System.out.println("setSerialVersionUID is used");
		this.serialVersionUID = serialVersionUID;
	}

	public Integer getResearchId() {
		System.out.println("getResearchId is used");
		return researchId;
	}

	public void setResearchId(Integer researchId) {
		System.out.println("setResearchId is used");
		this.researchId = researchId;
	}

	public String getVersion() {
		System.out.println("getVersion is used");
		return version;
	}

	public void setVersion(String version) {
		System.out.println("setVersion is used");
		this.version = version;
	}

	public String getGrade() {
		System.out.println("getGrade is used");
		return grade;
	}

	public void setGrade(String grade) {
		System.out.println("setGrade is used");
		this.grade = grade;
	}

}
