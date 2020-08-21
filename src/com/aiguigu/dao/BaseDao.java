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
	//��Ҫ��ȡʵ�ʵ�type
	private Class<T> type;
	public BaseDao(){
		//��ȡ��������,�����Ǵ�������
		ParameterizedType superclass=(ParameterizedType) this.getClass().getGenericSuperclass();
		System.out.println(superclass.getClass());
		//��ȡ����������
		type=(Class<T>) superclass.getActualTypeArguments()[0];
	}
	//��ȡһ������
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
	//��ȡ����ļ���
	public List<T> getBeanList(String sql,Object...params) throws SQLException{
		//1.��ȡ���ݿ�����
		Connection connection=JDBCUtils.getConnection();
		List<T> query=null;
		try {
			query=(List<T>)runner.query(connection, sql,new BeanListHandler<>(type), params);
			return query;
		} catch (SQLException e) {
			//2.��ѯһ������
			System.out.println("getBeanList�쳣");
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(connection);
		}
		return query;
	}
	//ִ����ɾ��
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
	//���ص���ֵ�ķ���
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
	//��������
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
