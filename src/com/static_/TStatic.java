package com.static_;

public class TStatic {
	static int i;

	public TStatic() {
		i = 4;
	}

	public TStatic(int j) {
		i = j;
	}

	public static void main(String args[]) {
		TStatic t = new TStatic(5); // 声明对象引用，并实例化
		System.out.println(TStatic.i);
		TStatic tt = new TStatic(); // 同上
		System.out.println(t.i);
		System.out.println(tt.i);
		System.out.println(t.i);
	}
}
