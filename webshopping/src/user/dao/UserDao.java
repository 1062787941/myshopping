package user.dao;

import user.daomain.User;

public interface UserDao {

	User findByUsername(String username) throws Exception;

	void save(User user);

	User findByCode(String code);

	void update(User existUser);

	User login(User user);

}
