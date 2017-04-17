package orders.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Order;

import orders.daomain.OrderItem;

import org.apache.ibatis.session.SqlSessionFactory;

public class OrderDaoImpl implements OrderDao{
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	//保存订单
	public void save(Order order) {
		sqlSessionFactory.openSession().
		insert("OrderNameSpace.save", order);
	}
	
	// 查询我的订单分页查询:统计个数
	public int findCountByUid(Integer uid) {
		int i = sqlSessionFactory.openSession().
				selectOne("OrderNameSpace.findCountByUid", uid);
		return i;
	}
	
	//查询我的订单分页查询:查询数据
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("uid", uid);
		map.put("begin", begin);
		map.put("limit", limit);
		List<Order> lists = sqlSessionFactory.openSession().
				selectList("OrderNameSpace.findPageByUid", map);
		return lists;
	}
	
	//根据订单id查询订单
	public Order findByOid(Integer oid) {
		Order o = sqlSessionFactory.openSession().
				selectOne("OrderNameSpace.findByOid", oid);
		return o;
	}
	
	//修改订单的方法
	public void update(Order currOrder) {
		sqlSessionFactory.openSession().
		update("OrderNameSpace.update", currOrder);
	}
	// DAO中统计订单个数的方法
	public int findCount(){
		return sqlSessionFactory.openSession().
				selectOne("OrderNameSpace.findCount");
	}
	
	// DAO中分页查询订单的方法
	public List<Order> findByPage(int begin, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("limit", limit);
		List<Order> lists = sqlSessionFactory.openSession().
				selectList("OrderNameSpace.findByPage", map);
		return lists;
	}
	
	// DAo中根据订单id查询订单项
	public List<OrderItem> findOrderItem(Integer oid){
		
		
		return null;
	}
}
