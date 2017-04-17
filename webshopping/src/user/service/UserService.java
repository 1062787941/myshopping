package user.service;


public interface UserService {

	// 按名次查询是否有该用户:
	public abstract User findByUsername(String username) throws Exception;
	
	// 注册用户存入数据库代码实现
	public void save(User user) throws Exception ;
	
	// 根据激活码查询用户
	public User findByCode(String code);
	
	// 修改用户状态的方法
	public void update(User existUser);
		
	// 用户登录的方法
	public User login(User user);
	
	//----------------admin中的方法,后面去实现------------
	//public int findCount();
//	public List<User> findByPage(int begin, int limit);
	
//	public User findByUid(Integer uid);
	
//	public void delete(User existUser);
}
