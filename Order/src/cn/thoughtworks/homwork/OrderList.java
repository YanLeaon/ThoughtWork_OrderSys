package cn.thoughtworks.homwork;

import java.util.TreeMap;
/**
 * 用于存储订单的类
 * @author LeiYang
 * */
public class OrderList {
	// 数组分别存储场地A，B，C，D的订单。
	private static TreeMap<String,Order>[] arr = new TreeMap[4];

	private static OrderList instance = new OrderList();
	
	private OrderList(){
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new TreeMap<String,Order>();
		}
	}
	
	public static OrderList getOrderList(){
		return instance;
	}
	
	public TreeMap<String,Order>[] getArr(){
		return arr;
	}
	// 将订单存入
	public void addOrder(Order order) throws OrderIsNotInvalidException{
//		System.out.println(order.getBookArea());
		switch (order.getBookArea()) {
		case 'A':
			arr[0].put(order.getBookDateAndStartTime(),order);
			break;
		case 'B':
			arr[1].put(order.getBookDateAndStartTime(),order);
			break;
		case 'C':
			arr[2].put(order.getBookDateAndStartTime(),order);
			break;
		case 'D':
			arr[3].put(order.getBookDateAndStartTime(),order);
			break;
		default:						//输入不合法	
			throw new OrderIsNotInvalidException("Error: the booking is invalid!");
		}
	}
	
	/**
	 * 遍历订单，查询并返回符合要求的订单，返回为空代表订单不存在
	 * throws OrderIsNotInvalidException ，表示订单不合法
	 * @author LeiYang
	 * */
	public Order findOrder(Order o) throws OrderIsNotInvalidException{
		switch (o.getBookArea()) {
		case 'A':
			return arr[0].get(o.getBookDateAndStartTime());
		case 'B':
			return arr[1].get(o.getBookDateAndStartTime());
		case 'C':
			return arr[2].get(o.getBookDateAndStartTime());
		case 'D':
			return arr[3].get(o.getBookDateAndStartTime());
		default:
			throw new OrderIsNotInvalidException("Error: the booking is invalid!");
		}
	}
	
	public Order findOrder(char area, String bookDateAndStartTime) throws OrderIsNotInvalidException{
		switch (area) {
		case 'A':
			return arr[0].get(bookDateAndStartTime);
		case 'B':
			return arr[1].get(bookDateAndStartTime);
		case 'C':
			return arr[2].get(bookDateAndStartTime);
		case 'D':
			return arr[3].get(bookDateAndStartTime);
		default:
			throw new OrderIsNotInvalidException("Error: the booking is invalid!");
		}
	}

}
