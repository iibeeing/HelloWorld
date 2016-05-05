/**   
* @Title: TestRollback.java 
* @Package com.transaction 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Bee
* @date 2016-3-18 ����2:50:11 
* @version V1.0   
*/ 
package com.transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.factory.ConnectionFactory;

/**   
 * �����ƣ�TestRollback   
 * ��������   
 * �����ˣ�Bee   
 * ����ʱ�䣺2016-3-18 ����2:50:11   
 * �޸��ˣ�Bee   
 * �޸�ʱ�䣺2016-3-18 ����2:50:11   
 * �޸ı�ע��   
 * @version    
 */
public class TestRollback {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			con = ConnectionFactory.getConnection();
			//�����ֶ��ύ
			con.setAutoCommit(false);
			StringBuffer sql = new StringBuffer();
			sql.append(" select total ");
			sql.append(" from td_account ");
			sql.append(" where username = ? ;");
			pstm = con.prepareStatement(sql.toString());
			pstm.setString(1, "jack");
			rs = pstm.executeQuery();
			System.out.println(sql.toString());
			int total = 0;
			if(rs.next()){
				total = rs.getInt("total");
			}
			if(total > 8000){
				StringBuffer updateA = new StringBuffer();
				updateA.append(" update td_account ");
				updateA.append(" set total = total - ? ");
				updateA.append(" where username = ? ;");
				pstm = con.prepareStatement(updateA.toString());
				pstm.setInt(1, 8000);
				pstm.setString(2, "jack");
				System.out.println(updateA.toString());
				int isUpdate1 = pstm.executeUpdate();
				
				if(isUpdate1 > 0){
					System.out.println("jack �˻��ۿ�ɹ������׽��� ............................");
					StringBuffer updateB = new StringBuffer();
					updateB.append(" update td_account ");
					updateB.append(" set total = total + ? ");
					updateB.append(" where username = ? ;");
					//int n = 1/0;
					pstm = con.prepareStatement(updateB.toString());
					pstm.setInt(1, 8000);
					pstm.setString(2, "mary");
					int isUpdate2 = pstm.executeUpdate();
					System.out.println(updateB.toString());
					if(isUpdate2 > 0){
						System.out.println("mary �˻��յ������׽��� ............................");
					}else{
						System.out.println("mary �˻�ת��δ�ɹ�.............................");
					}
				}else{
					System.out.println("jack �˻�ת��δ�ɹ�.............................");
				}
			}else{
				System.out.println(" ���㣬����ȡ��............................");
			}
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			try{
				System.out.println(" ����ʧ�ܣ������ع�............................");
				con.rollback();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		finally{
			ConnectionFactory.close(con, pstm, rs);
		}
	}
}
