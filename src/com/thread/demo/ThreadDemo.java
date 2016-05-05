package com.thread.demo;

public class ThreadDemo {

	/*运行后，我们发现其实只启动了一个线程。*/
	public static void main(String[] args) {
		/*运行后，我们发现其实只启动了一个线程。*/
/*		ThreadTest t = new ThreadTest();
		t.start();
		t.start();
		t.start();
		t.start();*/
		
		/*运行后，我们发现其实只启动了一个线程。是不是程序有问题呢？我们修改一下程序。*/
		 /*再次运行，发现这四个线程对象各自占有各自的资源，并不是同时完成统一任务。
		 我们可以得出结论：Thread类实际上无法达到资源共享的目的。*/
/*        new ThreadTest().start();   
        new ThreadTest().start();   
        new ThreadTest().start();   
        new ThreadTest().start(); */
        
        /*那么，Runnable接口能不能达到这一目的呢？*/
        ThreadTest2 test=new ThreadTest2();   
        new Thread(test).start();   
        new Thread(test).start();   
        new Thread(test).start();   
        new Thread(test).start();    
        
        /*
        运行之后我们发现，这四个线程同时完成了我们需要完成的任务。
		通过以上比较我们即可得出Thread与Runnable的区别：
		1、Runnable适合于多个相同程序代码线程去处理统一资源的情况，把虚拟的cpu（线程）同程序的代码，数据有效分离，较好体现面向对象的编程的思想
		2、Runnable可以避免由于Java的单继承机制带来的局限。可以再继承其他类的同时，还能实现多线程的功能。
		3、Runnable能增加程序的健壮性。代码能够被多个线程共享。
         * */
        
	}

}

class ThreadTest extends Thread {
	private int count = 10;

	public void run() {
		while (count > 0) {
			System.out.println(Thread.currentThread().getName() + "   " + count--);
		}
	}
}

class ThreadTest2 implements Runnable   
{   
    private int count=10;   
    public void run()   
    {   
        while(count>0)   
        {   
            System.out.println(Thread.currentThread().getName()+"   "+count--);   
        }   
    }   
} 