package com.app.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.app.dao.AbstractDAO;
import com.app.dao.IGenericDAO;

public class OrderDAO  extends AbstractDAO implements IGenericDAO{
	

	
	
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
				
			/*	private int orderid;
				private int lineid;
				private int userid;
				private int state;
				private String origin;
				private String destination;
				private int userlongitude;
				private int userlatitude;
				private float money;
				private String time;
				*/
				 JSONObject temp = new JSONObject()   
		         .element( "orderid", rs.getInt("orderid"))  
		           .element( "lineid", rs.getInt("lineid"))  
		             .element( "userid", rs.getInt("userid"))  
		               .element( "state", rs.getInt("state"))  
		         .element( "origin", rs.getString("origin"))
		         .element( "destination", rs.getString("destination"))
		           .element( "userlongitude", rs.getInt("userlongitude"))  
		               .element( "userlatitude", rs.getInt("userlatitude"))  
		         .element( "money", rs.getFloat("money"))
		         .element( "time", rs.getString("ordertime"));
		        
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

