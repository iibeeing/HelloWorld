package com.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class TestCzzsbMaxClientsDataSource {

	/**
	 * @throws SQLException 
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlserver://10.30.215.171:1433;DatabaseName=CZZSBBM";
		String login = "sa"; // 用户名
		String password = "cccccc"; // 密码
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
		System.out.println("数据库名getCatalog - > " + con1.getCatalog());
		System.out.println("可。。。getHoldability - > " + con1.getHoldability());
		System.out.println("隔离级别getTransactionIsolation - > " + con1.getTransactionIsolation());
		System.out.println("是否自动提交getAutoCommit - > " + con1.getAutoCommit());
		
		DatabaseMetaData dbmd =  con1.getMetaData();
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("客户端信息 - > " + dbmd.getDatabaseProductName());
		System.out.println("客户端信息 - > " + dbmd.getDatabaseProductVersion());
		System.out.println("客户端信息 - > " + dbmd.getDriverVersion());
		System.out.println("客户端信息 - > " + dbmd.getTypeInfo());
		
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		//同一时间可以从池分配的最多连接数量。设置为0时表示无限制。
		System.out.println("数据源信息getMaxActive - > " + ds.getMaxActive());
		//池里不会被释放的最多空闲连接数量。设置为0时表示无限制。
		System.out.println("数据源信息getMaxIdle - > " + ds.getMaxIdle());
		//同一时间能够从语句池里分配的已备语句的最大数量。设置为0时表示无限制。
		System.out.println("数据源信息getMaxOpenPreparedStatements - > " + ds.getMaxOpenPreparedStatements());
		//在抛出异常之前，池等待连接被回收的最长时间（当没有可用连接时）。设置为-1表示无限等待。
		System.out.println("数据源信息getMaxWait - > " + ds.getMaxWait());
		//连接保持空闲而不被驱逐的最长时间。
		System.out.println("数据源信息getMinEvictableIdleTimeMillis - > " + ds.getMinEvictableIdleTimeMillis());
		//在不新建连接的条件下，池中保持空闲的最少连接数。
		System.out.println("数据源信息getMinIdle - > " + ds.getMinIdle());
		System.out.println("数据源信息getNumActive - > " + ds.getNumActive());
		System.out.println("数据源信息getNumIdle - > " + ds.getNumIdle());
		System.out.println("数据源信息getTimeBetweenEvictionRunsMillis - > " + ds.getTimeBetweenEvictionRunsMillis());
		/*System.out.println("客户端信息 - > " + dbmd.getDatabaseProductName());
		System.out.println("客户端信息 - > " + dbmd.getDatabaseProductVersion());
		System.out.println("客户端信息 - > " + dbmd.getDatabaseProductName());
		System.out.println("客户端信息 - > " + dbmd.getDatabaseProductVersion());
		System.out.println("客户端信息 - > " + dbmd.getDatabaseProductName());
		System.out.println("客户端信息 - > " + dbmd.getDatabaseProductVersion());
		System.out.println("客户端信息 - > " + dbmd.getDatabaseProductName());
		System.out.println("客户端信息 - > " + dbmd.getDatabaseProductVersion());*/
//		System.out.println("客户端信息 - > " + con1.getClientInfo());
//		System.out.println("警告信息 - > " + con1.getWarnings());
//		System.out.println("运行连接数：" + ds.getNumActive());
//		System.out.println("运行连接数：" + ds.getMaxActive());
	}

}
