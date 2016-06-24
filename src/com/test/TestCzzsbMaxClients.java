package com.test;

import java.io.InputStream;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.URL;

/**
* @ClassName: TestCzzsbMaxClients
* @Description: ����ר�������Բ���ϵͳ�ܳ��ܵ�����߳���
* @author BEE 
* @date 2016-3-14 ����11:47:23
 */
public class TestCzzsbMaxClients {
	public static int success = 0;
    public static int fail = 0;
    public static int reject = 0;
	/**
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param @param args    �趨�ļ�
	 * @return void    ��������
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a = System.currentTimeMillis();
		//�̸߳������������й�ϵ������4G�ڴ棬2000���Ͳ����ˣ������20G�ڴ棬���ܵ�10000��û����
        //ThreadDemo[] td = new ThreadDemo[6000];
		ThreadDemo[] td = new ThreadDemo[6000];
        for(int i=0;i<td.length;i++){
            td[i] = new ThreadDemo(i,a);
        }
        for(int i=0;i<td.length;i++){
            td[i].start();
            System.out.println("��ǰ�̣߳� " + i);
        }
	}
	public static  synchronized void setValue(int s,int f,int r){
        success+=s;
        fail+=f;
        reject+=r;
    }
 
    public static class ThreadDemo extends Thread {
        private int id = 0;
        private long s = 0;
        public ThreadDemo(int id,long s){
            this.id=id;
            this.s=s;
        }
         
        @Override
        public void run() {
            int success = 0;
            int request_fail = 0;
            int request_reject = 0;
            URL url;
            //i ������õ�̫С���̺߳ܿ������ˣ��������Ϳ��ܴﲻ���߶�
            for (int i = 0; i < 10000; i++) {
                try {
//                    url = new URL("http://ip:8080/Project1/test.jsp");
//                	url = new URL("http://10.30.215.115:7777/");
//                	url = new URL("http://61.128.226.200:81/");
                	//�Կ�
                	//url = new URL("http://61.128.226.207:80/");
                	//url = new URL("http://61.161.82.38:80/");
                	//����־Ը
                	url = new URL("http://192.168.4.161/gkzy/index.jsp");
                	
                	//��ȡ��url�����ݣ������html��ʹ�<html ��ʼֱ����ҳ���ȡ�꣬��</html>
                    InputStream is = url.openStream();
                    //ÿ�ζ�ȡ�Ĵ�С��100��byte ��Ҳ���� �����ҳ��Ĵ�С��10K����Ҫ 10*1024/100=105��
                    byte[] b = new byte[100];
                    StringBuffer sb = new StringBuffer();
                    //int n = 0;
                    while(is.read(b)!=-1){
                        String ss = new String(b,"utf-8");
                        if(!"".equals(ss.trim()))
                            sb.append(ss.trim());
                        //n++;
                    }
                    //System.out.println("n is " + n);
                    is.close();
                    success++;
                } catch (ConnectException e) {
                    request_fail++;
                }catch(SocketException ee){
                    request_reject++;
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            TestCzzsbMaxClients.setValue(success,request_fail,request_reject);
            System.out.println("request  --" + id + "--  url end.take "
                    + (System.currentTimeMillis() - s) + "ms success="+TestCzzsbMaxClients.success+" fail="+TestCzzsbMaxClients.fail+" request_reject="+TestCzzsbMaxClients.reject);
        }
    }
}
