package com.aiguigu.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.aiguigu.utils.*;

public class JDBCUtilsTest {
	public static void main(String[] args) throws SQLException{
		Connection connection=JDBCUtils.getConnection();
		System.out.println(connection);
		JDBCUtils.releaseConnection(connection);
	}
}
