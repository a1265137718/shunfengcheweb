package com.app.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.app.dao.AbstractDAO;
import com.app.dao.IGenericDAO;

public class ChatDAO extends AbstractDAO implements IGenericDAO{
	

	
	
	/**
	 * ����ִ�ж�������ѯ
	 * 
	 * @param sql
	 *            ���С������Ķ�������ѯ���
	 * @param conditions
	 *            ������ͬ����
	 * @return ���������Ķ��󼯺�
	 */

	public JSONArray getObjectsByConditions(String sql) {
		// ����һ������
		JSONArray array = new JSONArray();
		try {
			// 3)�������ݿ�����
			Connection conn = this.getConn();
			// 4)ִ��sql
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			// 5)��ȡ�����
			ResultSet rs = pstmt.executeQuery();
			// 6)��������
		
			while (rs.next()) {
				 
				 JSONObject temp = new JSONObject()   
		         .element( " chatid", rs.getInt("chatid"))  
		         .element( "fromid", rs.getInt("fromid"))
		         .element( "toid", rs.getString("toid"))
		         .element( "chatcontent", rs.getString("content"))
		         .element( "time", rs.getString("time"))
		         .element( "flag", rs.getInt("flag"))
				 .element( "freeze", rs.getInt("freeze"))
				 .element( "isread", rs.getInt("isread"));
			
				// ÿ������һ����Ա�û����ͽ�����ӵ�List��
				  array.add(temp);
			}
           
			// 7)�ͷ���Դ
			this.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;

	}
    
	

   




}
