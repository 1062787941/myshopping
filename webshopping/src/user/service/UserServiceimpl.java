package user.service;

import user.dao.UserDao;
import user.daomain.User;

public class UserServiceimpl implements UserService{
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findByUsername(String username) throws Exception {
		return userDao.findByUsername(username);
	}

	@Override
	public void save(User user) throws Exception {
		userDao.save(user);
	}

	@Override
	public User findByCode(String code) {
		userDao.findByCode(code);
		return null;
	}

	@Override
	public void update(User existUser) {
		userDao.update(existUser);
	}

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

}
