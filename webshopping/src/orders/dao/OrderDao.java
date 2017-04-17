package orders.dao;
import java.util.List;

import orders.daomain.Order;
import orders.daomain.OrderItem;


public interface OrderDao {
	
	// Dao层的保存订单额操作
	public void save(Order order);
	
	// Dao层查询我的订单分页查询:统计个数
	public int findCountByUid(Integer uid);
	
	// Dao层查询我的订单分页查询:查询数据
	public List<Order> findPageByUid(Integer uid, int begin, int limit);
	
	// DAO层根据订单id查询订单
	public Order findByOid(Integer oid);
	
	// DAO层修改订单的方法:
	public void update(Order currOrder);
	
	// DAO中统计订单个数的方法
	public int findCount();
	
	// DAO中分页查询订单的方法
	public List<Order> findByPage(int begin, int limit);
	
	// DAo中根据订单id查询订单项
	public List<OrderItem> findOrderItem(Integer oid);
	

}
