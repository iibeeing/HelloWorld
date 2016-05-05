package com.db.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class BasicDaoImpl implements BasicDao {

	@Override
	public Object get(Class<?> clazz, int id) {
		return null;
	}

	@Override
	public boolean save(final Object object) {
		Class<?> clazz = object.getClass();
		String simpleName = clazz.getSimpleName();
		final StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_").append(simpleName).append("(");
		final Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			if(!field.getName().equals("id")){
				sql.append(field.getName()).append(",");
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")").append("values(");
		for(int i=1;i<fields.length;i++){
			sql.append("?,");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		System.out.println("save sql is ： " + sql.toString());
		return template(new Callback<Boolean>(){

			@Override
			public Boolean doInCallback(Connection conn,
					PreparedStatement pstm, ResultSet rs) throws Throwable {
					pstm = conn.prepareStatement(sql.toString());
					int index = 1;
					for(Field field : fields){
						if(!field.getName().equals("id")){
							if(!field.isAccessible())
								field.setAccessible(true);
							Object temO = field.get(object);
							pstm.setObject(index, temO);
							index++;
						}
					}
					int row = pstm.executeUpdate();
					return row !=0 ? true : false;
			}
		});
	}

	/**
	 * 1、获得表名
	 * 2、构建Sql
	 * 3、执行
	 */
	@Override
	public boolean delete(Class<?> clazz, final int id) {
		//获取类名，不含包名
		String tableName = clazz.getSimpleName();
		final StringBuffer sql = new StringBuffer();
		sql.append(" delete from tb_").append(tableName);
		sql.append(" where id = ? ");
		return template(new Callback<Boolean>(){
			@Override
			public Boolean doInCallback(Connection conn,
					PreparedStatement pstm, ResultSet rs) throws Throwable {
				System.out.println("sql is ：" + sql.toString());
				pstm = conn.prepareStatement(sql.toString());
				pstm.setInt(1,id);
				int row = pstm.executeUpdate();
				return row != 0 ? true : false;
			}
		});
	}

	@Override
	public List<? extends Object> findAll(Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	protected interface Callback<E>{
		E doInCallback(Connection conn,PreparedStatement pstm,ResultSet rs) throws Throwable;
	}
	
	/**
	 * 数据操作的模版方法
	 * @param callback
	 * @return
	 * @throws DataAccessException
	 * 现阶段这个方法就是帮我们做来获取连接和关闭连接的动作，之后还可以处理事务操作
	 */
	protected <E> E template(Callback<E> callback) throws DataAccessException{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		conn = ConnectionFactory.getConnection();
		try{
			return callback.doInCallback(conn, pstm, rs);
		}catch (Throwable t) {
			throw new DataAccessException(t);
		}finally{
			ConnectionFactory.close(conn,pstm,rs);
		}
	}
}
