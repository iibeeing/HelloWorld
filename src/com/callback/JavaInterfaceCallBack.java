package com.callback;

/**
@ClassName: 用于学习Java回调。使用接口和匿名内部类
@Description: TODO(这里用一句话描述这个类的作用)
@author BEE 
@date 2016-5-20 上午11:03:20
 */



/*
 * Java里面的接口回调，最简单的情况示意如下
 */
interface A {
}

class B implements A {
}

class C implements A {
}

class Test2 {
	A b = new B();
	A c = new C();
}

/*
 * 我们重点关注——用Java接口实现回调函数的等价功能 简单来说，就是某个类的某个函数，接收一个接口作为参数（或者直接把该接口作为field）,
 * 那么就可以在这个函数中调用接口里面的方法了，称为回调 而接口的实现可以千变万化，将不同的接口的实现类传入，就可实现不同的功能
 * 
 * 例如：
 */
interface Hello {
	void sayHello();
}

class Man {

	private Hello hello;

	public Man(Hello hello) {
		this.hello = hello;
	}

	public void say() {
		hello.sayHello();
	}

}

class HelloTest {

	public static void test() {
		Man chinese = new Man(new Hello() {
			public void sayHello() {
				System.out.println("你好");
			}
		});
		chinese.say();

		Man english = new Man(new Hello() {
			public void sayHello() {
				System.out.println("hello");
			}
		});
		english.say();
	}
}

/*
 * 上面的例子是调用类“拥有接口”，接口是不知道调用类的 若接口和调用类要交互，那他们就是相互“拥有” 考虑这样一个应用：
 * NameChanger动态地改变Client的名字
 * 那NameChanger的changeName方法就要接收一个Client对象，然后获取（调用）Client的名字并作不同的处理
 * Client也要持有NameChanger，因为要打印改变后的名字
 */
class Client {

	private INameChanger changer;
	private String clientName;

	public Client(INameChanger changer) {
		this.changer = changer;
	}

	public void changeNameNow() {
		String newName = changer.changeName(this);
		this.clientName = newName;
	}

	public String getName() {
		return clientName;
	}

	public void setName(String clientName) {
		this.clientName = clientName;
	}

}

interface INameChanger {

	String changeName(Client client);

}

class ChangeNameTest {

	public static void test() {

		Client client = new Client(new INameChanger() {
			public String changeName(Client client) {
				return "Mr." + client.getName();
			}
		});
		client.setName("Tom");
		client.changeNameNow();
		System.out.println(client.getName());

		Client client2 = new Client(new INameChanger() {
			public String changeName(Client client) {
				return "Miss." + client.getName();
			}
		});
		client2.setName("Lucy");
		client2.changeNameNow();
		System.out.println(client2.getName());

	}

}

/*
 * 考虑这样一个应用：希望在某个事件发生时得到通知
 */
interface InterestingEvent {

	public void interestingEvent();

}

class EventNotifier {
	// 写成private List<InterestingEvent>
	// eventList可以监听多个事件
	private InterestingEvent event;
	private boolean somethingHappened;

	public EventNotifier(InterestingEvent ie) {
		this.event = ie;
		this.somethingHappened = false;
	}

	public void setHappened() {
		this.somethingHappened = true;
	}

	public void doWork() {
		if (somethingHappened) {
			event.interestingEvent();
		}
	}

}

class ButtonPressedEvent implements InterestingEvent {

	@SuppressWarnings("unused")
	private EventNotifier en;

	public ButtonPressedEvent() {
		en = new EventNotifier(this);
	}

	public void interestingEvent() {
		System.out.println("button pressed ");
	}

}

class EventNotifierTest {

	public static void test() {
		// 这里有两种调用方法。其中第二种采用匿名内部类，其原理跟上面“改变Client名字”是一样的
		EventNotifier en = new EventNotifier(new ButtonPressedEvent());
		en.setHappened();
		en.doWork();

		EventNotifier en2 = new EventNotifier(new InterestingEvent() {
			public void interestingEvent() {
				System.out.println("inputtext change ");
			}
		});
		en2.setHappened();
		en2.doWork();

	}
}

// 这个类是用来测试的
public class JavaInterfaceCallBack {

	public static void main(String[] args) {
		HelloTest.test();
		ChangeNameTest.test();
		EventNotifierTest.test();

	}

}
