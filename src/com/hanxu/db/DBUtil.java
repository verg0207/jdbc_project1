package com.hanxu.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "verg";

	private static java.sql.Connection conn = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 获得数据库的连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static java.sql.Connection getConnection() {
		return conn;
	}

	public static void main(String[] args) throws Exception {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获得数据库的连接
		java.sql.Connection conn = DriverManager.getConnection(URL, USER,
				PASSWORD);
		// 通过数据库的连接操作数据库，实现增删改查
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("select user_name,age from imooc_goddess"); // 引入java.sql中的resultset

		while (rs.next()) {
			System.out.println(rs.getString("user_name") + ","
					+ rs.getInt("age"));
		}
	}
}
