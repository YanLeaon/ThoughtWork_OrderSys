package cn.thoughtworks.homwork;

import java.util.TreeMap;
/**
 * ���ڴ洢��������
 * @author LeiYang
 * */
public class OrderList {
	// ����ֱ�洢����A��B��C��D�Ķ�����
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
	// ����������
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
		default:						//���벻�Ϸ�	
			throw new OrderIsNotInvalidException("Error: the booking is invalid!");
		}
	}
	
	/**
	 * ������������ѯ�����ط���Ҫ��Ķ���������Ϊ�մ�����������
	 * throws OrderIsNotInvalidException ����ʾ�������Ϸ�
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
