package com.collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DuplicateRemoval {
	// �Լ�ȥ�أ����Ӷ�o(n^2)
	List<String> DefineRemovalDuplicate(String[] str) {
		List<String> resultList = new ArrayList<String>();
		for (String s : str) {
			if (!resultList.contains(s)) {
				resultList.add(s);
			}
		}
		return resultList;
	}

	static LinkedHashSet<String> LinkedHashSetRemovelDuplicate(String[] str) {
		List<String> list = Arrays.asList(str);
		for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			System.out.print(element + ",");

		}
		System.out.println();
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.addAll(list);
		for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			System.out.println(element);
		}
		return set;
	}
	/**
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param @param args �趨�ļ�
	 * @return void ��������
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = { "121", "222", "234", "345", "456", "567", "222",
				"131", "121", "222", "121" };
/*		List<String> tempList = new ArrayList<String>();
		for (String s : str) {
			if (!tempList.contains(s)) {
				tempList.add(s);
			}
		}
		for (String i : tempList) {
			System.out.println(i);
		}*/
		long start = System.currentTimeMillis();
		Set set = LinkedHashSetRemovelDuplicate(str);
		long end = System.currentTimeMillis();
		long use = end - start;
		System.out.println("��ʱ " + use);
	}


}
