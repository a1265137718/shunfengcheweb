package com.app.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.app.dao.AbstractDAO;
import com.app.dao.IGenericDAO;

public class CommentDAO  extends AbstractDAO implements IGenericDAO{
	

	
	
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
				/*  private int commentid;
				   private int fromuserid;
				   private int touserid;
				   private int lineid;
				   private String content;
				   private String time;*/
				 JSONObject temp = new JSONObject()   
		         .element( "commentid", rs.getInt("commentid"))  
		         .element( "fromuserid", rs.getInt("fromuserid"))
		          .element( "touserid", rs.getInt("touserid"))  
		         .element( "lineid", rs.getInt("lineid"))
		         .element( "content", rs.getString("content"))
		         .element( "time", rs.getString("time"));
		        
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
