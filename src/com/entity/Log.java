package com.entity;

import java.util.Date;

import com.annotation.Entity;


/**
@ClassName: Log
@Description: 日志类
@author BEE 
@date 2016-4-19 下午2:56:35
 */
@Entity
public class Log {

	private String id;
	private String statement;
	private String operateTime;
	private int type;
	private String userid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}	
	
}
