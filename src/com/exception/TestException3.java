package com.exception;

public class TestException3 {
	 public static void throwChecked(int a) throws Exception
	    {
	        if (a < 0)
	        {
	            /**
	             * �����׳�Exception�쳣 �Ĵ�����봦��try������ڴ�throws�����ķ�����
	             */
	            throw new Exception("a��ֵС��0��������Ҫ��");
	        }
	    }

	    public static void throwRuntime(int a)
	    {
	        if (a < 0)
	        {
	            /**
	             * �����׳�RuntimeException�쳣���ȿ�����ʽ������쳣 Ҳ������ȫ���������쳣���Ѹ��쳣���������ĵ����ߴ���
	             */
	            throw new RuntimeException("a��ֵС��0��������Ҫ��");
	        } else
	        {
	            System.out.println("a��ֵΪ��" + a);
	        }
	    }

	    public static void main(String[] args)
	    {
	        try
	        {
	            /**
	             * �˴������˴�throws�����ķ�����������ʾ������쳣��ʹ��try...catch�� ����Ҫ��main�������ٴ������׳�
	             */
	            throwChecked(-3);
	        } catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
	        throwRuntime(3);
	    }
}
