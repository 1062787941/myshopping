package user.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import user.daomain.User;

/**
 * 用户模块持久层代码
 */
public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	// TODO
	@Override // 按名次查询是否有该用户
	public User findByUsername(String username) throws Exception {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectOne("UserNameSpace.findByUsername", username);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override // 注册用户存入数据库代码实现
	public void save(User user) {
		sqlSessionFactory.openSession().insert("UserNameSpace.save",user);
	}

	@Override // 根据激活码查询用户
	public User findByCode(String code) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("UserNameSpace.findByCode", code);
		if(null != user){
			return user;
		}
		return null;
	}

	@Override// 修改用户状态的方法
	public void update(User existUser) {
		sqlSessionFactory.openSession().update("UserNameSpace.update",existUser);
	}

	@Override //用户登录
	public User login(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User u = sqlSession.selectOne("UserNameSpace.login", user);
		System.out.println(u);
		if(null != u){
			return u;
		}
		return null;
	}
}