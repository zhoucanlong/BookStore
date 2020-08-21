package com.aiguigu.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//获取和释放数据库连接
public class JDBCUtils {
	private static DataSource ds=new ComboPooledDataSource("webDataSource");
	public static Connection getConnection() throws SQLException{
		Connection connection=null;
		connection=ds.getConnection();
		return connection;
	}
	//释放数据库连接
	public static void releaseConnection(Connection connection) throws SQLException{
				if(connection!=null) connection.close();
	}
}
