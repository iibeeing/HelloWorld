package com.test;

import java.io.InputStream;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.URL;

/**
* @ClassName: TestCzzsbMaxClients
* @Description: 成招专升本考试测试系统能承受的最大线程数
* @author BEE 
* @date 2016-3-14 上午11:47:23
 */
public class TestCzzsbMaxClients {
	public static int success = 0;
    public static int fail = 0;
    public static int reject = 0;
	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a = System.currentTimeMillis();
		//线程跟本机的配置有关系，本机4G内存，2000多点就不行了，如果是20G内存，则跑到10000都没问题
        //ThreadDemo[] td = new ThreadDemo[6000];
		ThreadDemo[] td = new ThreadDemo[6000];
        for(int i=0;i<td.length;i++){
            td[i] = new ThreadDemo(i,a);
        }
        for(int i=0;i<td.length;i++){
            td[i].start();
            System.out.println("当前线程： " + i);
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
            //i 如果设置的太小，线程很快就完成了，并发量就可能达不到高度
            for (int i = 0; i < 10000; i++) {
                try {
//                    url = new URL("http://ip:8080/Project1/test.jsp");
//                	url = new URL("http://10.30.215.115:7777/");
//                	url = new URL("http://61.128.226.200:81/");
                	//自考
                	//url = new URL("http://61.128.226.207:80/");
                	//url = new URL("http://61.161.82.38:80/");
                	//普招志愿
                	url = new URL("http://192.168.4.161/gkzy/index.jsp");
                	
                	//读取该url的内容，如果是html则就从<html 开始直到该页面读取完，即</html>
                    InputStream is = url.openStream();
                    //每次读取的大小是100个byte ，也就是 如果该页面的大小是10K，则要 10*1024/100=105次
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
