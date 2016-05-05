package com.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class TestCzzsbMaxClientsDataSource {

	/**
	 * @throws SQLException 
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param @param args    �趨�ļ�
	 * @return void    ��������
	 * @throws
	 */
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlserver://10.30.215.171:1433;DatabaseName=CZZSBBM";
		String login = "sa"; // �û���
		String password = "cccccc"; // ����
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		
		BasicDataSource ds = new BasicDataSource();
//		ds.setUrl("jdbc:sqlserver://10.30.215.171:1433;DatabaseName=CZZSBBM");
		ds.setUrl("jdbc:sqlserver://192.168.0.126:1433;DatabaseName=CZZSBBM");
		//ds.setUrl("jdbc:sqlserver://192.168.0.126:1433;DatabaseName=czbm2013");
		ds.setDriverClassName(driver);
		ds.setUsername(login);
		//ds.setPassword(password);
		ds.setPassword("!czbm!2013");
//		ds.setMaxActive(4);
//		ds.setMaxIdle(2);
//		ds.setMaxWait(5000);
		Connection con1 = ds.getConnection();
		//System.out.println("con1 - > " + con1);
		System.out.println("���ݿ���getCatalog - > " + con1.getCatalog());
		System.out.println("�ɡ�����getHoldability - > " + con1.getHoldability());
		System.out.println("���뼶��getTransactionIsolation - > " + con1.getTransactionIsolation());
		System.out.println("�Ƿ��Զ��ύgetAutoCommit - > " + con1.getAutoCommit());
		
		DatabaseMetaData dbmd =  con1.getMetaData();
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getDatabaseProductName());
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getDatabaseProductVersion());
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getDriverVersion());
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getTypeInfo());
		
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		//ͬһʱ����Դӳط���������������������Ϊ0ʱ��ʾ�����ơ�
		System.out.println("����Դ��ϢgetMaxActive - > " + ds.getMaxActive());
		//���ﲻ�ᱻ�ͷŵ���������������������Ϊ0ʱ��ʾ�����ơ�
		System.out.println("����Դ��ϢgetMaxIdle - > " + ds.getMaxIdle());
		//ͬһʱ���ܹ��������������ѱ������������������Ϊ0ʱ��ʾ�����ơ�
		System.out.println("����Դ��ϢgetMaxOpenPreparedStatements - > " + ds.getMaxOpenPreparedStatements());
		//���׳��쳣֮ǰ���صȴ����ӱ����յ��ʱ�䣨��û�п�������ʱ��������Ϊ-1��ʾ���޵ȴ���
		System.out.println("����Դ��ϢgetMaxWait - > " + ds.getMaxWait());
		//���ӱ��ֿ��ж�����������ʱ�䡣
		System.out.println("����Դ��ϢgetMinEvictableIdleTimeMillis - > " + ds.getMinEvictableIdleTimeMillis());
		//�ڲ��½����ӵ������£����б��ֿ��е�������������
		System.out.println("����Դ��ϢgetMinIdle - > " + ds.getMinIdle());
		System.out.println("����Դ��ϢgetNumActive - > " + ds.getNumActive());
		System.out.println("����Դ��ϢgetNumIdle - > " + ds.getNumIdle());
		System.out.println("����Դ��ϢgetTimeBetweenEvictionRunsMillis - > " + ds.getTimeBetweenEvictionRunsMillis());
		/*System.out.println("�ͻ�����Ϣ - > " + dbmd.getDatabaseProductName());
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getDatabaseProductVersion());
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getDatabaseProductName());
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getDatabaseProductVersion());
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getDatabaseProductName());
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getDatabaseProductVersion());
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getDatabaseProductName());
		System.out.println("�ͻ�����Ϣ - > " + dbmd.getDatabaseProductVersion());*/
//		System.out.println("�ͻ�����Ϣ - > " + con1.getClientInfo());
//		System.out.println("������Ϣ - > " + con1.getWarnings());
//		System.out.println("������������" + ds.getNumActive());
//		System.out.println("������������" + ds.getMaxActive());
	}

}
