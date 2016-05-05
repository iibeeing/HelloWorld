package com.eventdelegation;

/**
 * 
* @ClassName: Notifier
* @Description: 放哨人员抽象类
* @author BEE 
* @date 2016-3-23 上午9:56:13
 */
public abstract class Notifier {
	private EventHandler eventHandler = new EventHandler();
	public EventHandler getEventHandler() {
		return eventHandler;
	}
	public void setEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}
	// 增加需要帮忙放哨的学生
	public abstract void addListener(Object object, String methodName,Object... args);
	// 告诉所有要帮忙放哨的学生：老师来了
	public abstract void notifyX();
}
