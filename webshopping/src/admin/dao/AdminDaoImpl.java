package admin.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import admin.daomain.Admin;

public class AdminDaoImpl implements AdminDao{
	
	private SqlSessionFactory factory;
	
	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Override //完成登录的代码
	public Admin login(Admin admin) {
		return factory.openSession().selectOne("AdminNameSpace.login",admin);
	}

}
