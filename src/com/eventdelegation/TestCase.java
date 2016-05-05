package com.eventdelegation;

import java.util.Date;
import org.junit.Test;
public class TestCase {
	@Test
	public void test() {
		// ����һ����ְ����ķ�����
		Notifier goodNotifier = new GoodNotifier();
		// ����һ������Ϸ��ͬѧ����ʼ����Ϸ
		PlayingGameListener playingGameListener = new PlayingGameListener();
		// ����һ�������ӵ�ͬѧ����ʼ������
		WatchingTVListener watchingTVListener = new WatchingTVListener();
		// ����Ϸ��ͬѧ���߷��ڵ�ͬѧ����ʦ���˸���һ��
		goodNotifier.addListener(playingGameListener, "stopPlayingGame", new Date());
		// �����ӵ�ͬѧ���߷��ڵ�ͬѧ����ʦ���˸���һ��
		goodNotifier.addListener(watchingTVListener, "stopWatchingTV", new Date());
		try {
			// һ��ʱ���
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ��ʦ���֣����ڵ���֪ͨ����Ҫ��æ��ͬѧ:��ʦ����
		goodNotifier.notifyX();
	}
}
