package com.threadlocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*由运行结果可知，各线程都用于各自的Local变量，并各自读写互不干扰。*/
public class ThreadLocalTest {
	static class ThreadLocalVariableHolder {
		private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
			private Random random = new Random();

			protected synchronized Integer initialValue() {
				return random.nextInt(10000);
			}
		};

		public static void increment() {
			value.set(value.get() + 1);
		}

		public static int get() {
			return value.get();
		}
	}

	static class Accessor implements Runnable {
		private final int id;

		public Accessor(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				ThreadLocalVariableHolder.increment();
				System.out.println(this);
				Thread.yield();
			}
		}

		@Override
		public String toString() {
			return "#" + id + ": " + ThreadLocalVariableHolder.get();
		}

	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new Accessor(i));
		}
		try {
			TimeUnit.MICROSECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdownNow();
	}

}