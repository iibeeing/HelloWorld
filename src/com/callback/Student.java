package com.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student implements DoHomeWork {
private static final Logger logger = LoggerFactory.getLogger(Student.class);
	
	
	@Override
	public void doHomeWork(String question, String answer) {
		System.out.println("作业本");
		if (answer != null) {
			System.out.println("作业：" + question + " 答案：" + answer);
		} else {
			System.out.println("作业：" + question + " 答案：" + "(空白)");
		}
	}

	/**
	* @Title: ask
	* @Description: #新开的线程纯粹用来等待好室友来写完作用。由于在好室友类中设置了3秒的等待时间，
	* 所以可以看到goHome方法将先执行。 #意味着该学生在告知好室友做作用后，就可以做自己的事情去了，
	* 不需要同步阻塞去等待结果。 #一旦好室友完成作用，写入作业本，该现场也就结束运行了。
	* @param @param homework
	* @param @param roomMate    设定文件
	* @return void    返回类型
	* @throws
	 */
	public void ask(final String homework, final RoomMate roomMate) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				roomMate.getAnswer(homework, Student.this);
			}
		}).start();
		goHome();
	}

	public void goHome() {
		System.out.println("我回家了……好室友，帮我写下作业。");
/*		logger.info("我回家了……好室友，帮我写下作业。");
		logger.debug("我回家了……好室友，帮我写下作业。");
		logger.error("我回家了……好室友，帮我写下作业。");
		logger.trace("我回家了……好室友，帮我写下作业。");
		logger.warn("我回家了……好室友，帮我写下作业。");*/
	}

	public static void main(String[] args) {
/*		RoomMate roomMate = new RoomMate();
		roomMate.getAnswer("1+1=?", new DoHomeWork() {
			@Override
			public void doHomeWork(String question, String answer) {
				System.out.println("问题：" + question + " 答案：" + answer);
			}
		});*/
		Student student = new Student();
	    String homework = "当x趋向于0，sin(x)/x =?";
	    student.ask(homework, new RoomMate());
	}

}
