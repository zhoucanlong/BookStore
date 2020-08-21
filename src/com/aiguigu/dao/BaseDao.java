package com.aiguigu.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.aiguigu.utils.JDBCUtils;

public class BaseDao<T> {
	private QueryRunner runner=new QueryRunner();
	//需要获取实际的type
	private Class<T> type;
	public BaseDao(){
		//获取父类类型,父类是带参数的
		ParameterizedType superclass=(ParameterizedType) this.getClass().getGenericSuperclass();
		System.out.println(superclass.getClass());
		//获取参数的类型
		type=(Class<T>) superclass.getActualTypeArguments()[0];
	}
	//获取一个对象
	public T getBean(String sql,Object...params) throws SQLException{
		Connection connection=JDBCUtils.getConnection();
		T query=null;
		try {
			query=(T)runner.query(connection, sql, new BeanHandler<>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(connection);
		}
		return query;
	}
	//获取对象的集合
	public List<T> getBeanList(String sql,Object...params) throws SQLException{
		//1.获取数据库连接
		Connection connection=JDBCUtils.getConnection();
		List<T> query=null;
		try {
			query=(List<T>)runner.query(connection, sql,new BeanListHandler<>(type), params);
			return query;
		} catch (SQLException e) {
			//2.查询一组数据
			System.out.println("getBeanList异常");
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(connection);
		}
		return query;
	}
	//执行增删改
	public int update(String sql,Object ...params) throws SQLException{
		Connection connection=JDBCUtils.getConnection();
		int count=0;
		try {
			count=runner.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(connection);
		}
		return count;
	}
	//返回单个值的方法
	public Object getSingleValue(String sql,Object ...params) throws SQLException{
		Connection connection=JDBCUtils.getConnection();
		Object query=null;
		int count=0;
		try {
			query=runner.query(connection, sql,new ScalarHandler() ,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(connection);
		}
		return query;
	}
	//批处理方法
	public int batch(String sql,Object[][] params){
		Connection connection=null;
		try {
			connection = JDBCUtils.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			runner.batch(connection, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				JDBCUtils.releaseConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
}
