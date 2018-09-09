package com.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelperFunction {

	private ConnectionPool dbCon;

	public HelperFunction() {
		dbCon = new ConnectionPool();
	}

	public boolean upload(int id, String image_path) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			String query = "UPDATE image_details set image_path = ? WHERE id = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(2, id);
			ps.setString(1, image_path);
			ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			dbCon.releaseConnection(con);
		}
		return true;
	}

	public String getPath(int id) {
		Connection con = null;
		String path = null;
		try {
			con = dbCon.getAvailableConnection();
			String query2 = "SELECT id, image_path FROM image_details WHERE id = ? ";
			PreparedStatement ps = con.prepareStatement(query2);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				path = rs.getString("image_path");
			}
		} catch (SQLException e) {

		} finally {
			dbCon.releaseConnection(con);
		}
		return path;
	}

	public static void main(String[] args) {
		HelperFunction h = new HelperFunction();
		System.out.println("PATH" + h.getPath(1));
	}

}
