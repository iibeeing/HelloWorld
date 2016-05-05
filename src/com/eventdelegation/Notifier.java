package com.eventdelegation;

/**
 * 
* @ClassName: Notifier
* @Description: ������Ա������
* @author BEE 
* @date 2016-3-23 ����9:56:13
 */
public abstract class Notifier {
	private EventHandler eventHandler = new EventHandler();
	public EventHandler getEventHandler() {
		return eventHandler;
	}
	public void setEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}
	// ������Ҫ��æ���ڵ�ѧ��
	public abstract void addListener(Object object, String methodName,Object... args);
	// ��������Ҫ��æ���ڵ�ѧ������ʦ����
	public abstract void notifyX();
}
