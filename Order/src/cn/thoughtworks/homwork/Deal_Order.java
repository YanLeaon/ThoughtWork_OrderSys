package cn.thoughtworks.homwork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Deal_Order {

	private static final OrderList list = OrderList.getOrderList();

	/**
	 * �ж��Ƿ����ȡ���ö�����
	 * 
	 * @return ���Ա�ȡ���򷵻�true
	 * */
	private boolean isOrderCanBeCancel(Order order) {
		if (order.isCancel()) {
			try {
				Order findOrder = list.findOrder(order);
				if (findOrder != null && !findOrder.isCancel()) {
					if (findOrder.equalsCancelOrder(order))
						return true;
					else
						return false;
				}
			} catch (OrderIsNotInvalidException e) {
				System.out.println(e.getMessage());
			}
		}
		return false;
	}

	/**
	 * �ж�Order���Ѵ��ڵĶ���ʱ���Ƿ��ͻ,����Ԥ����������ͬ�����ж������Ƚ�
	 * 
	 * @return ��ͻ�򷵻�true
	 * */
	private boolean isOrderCoflict(Order order) {
		Order existOrder;
		Date orderStartTime;
		Date orderEndTime;
		Date existOrderStartTime;
		Date existOrderEndTime;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		try {// ������������ڼ���ʼʱ�䣬����Ҫ�Ƚϵ�order������ͬ��order���������ж�
			for (int i = 9; i <= 22; i++) {

				existOrder = list.findOrder(order.getBookArea(),
						order.getBookDate() + i + ":00");
				// ��ѯ���Ķ�����Ϊȡ������
				if (existOrder != null && !existOrder.isCancel()) {
					orderStartTime = sdf.parse(order.getBookStartTime());
					orderEndTime = sdf.parse(order.getBookEndTime());
					existOrderStartTime = sdf.parse(existOrder
							.getBookStartTime());
					existOrderEndTime = sdf.parse(existOrder.getBookEndTime());
					if (orderStartTime.equals(existOrderStartTime)
							|| orderEndTime.equals(existOrderEndTime)) {
						return true;
					} else if (orderStartTime.after(existOrderStartTime)
							&& orderStartTime.before(existOrderEndTime)) {
						return true;
					} else if (orderEndTime.after(existOrderStartTime)
							&& orderEndTime.before(existOrderEndTime)) {
						return true;
					}
				}
			}

		} catch (OrderIsNotInvalidException | ParseException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	/**
	 * �ж϶����Ƿ�Ϊȡ������
	 * */
	/*
	 * private boolean isCancelOrder(Order o) { return o.isCancel(); }
	 */

	/**
	 * ��������
	 * 
	 * @return �����Ķ������󣬵�����null��ʾ����ʧ��
	 * */
	private Order creatOrder(String orderStr) {
		String[] str = orderStr.split(" ");
		boolean cancel = false;

		if (str.length < 4 || str.length > 5 || str[3].length() > 1) {
			System.out.println(">Error: the booking is invalid!");
			return null;
		}
		// �����ָ���쳣
		String[] timeStr = str[2].split("~");
		String startTime = timeStr[0];
		String endTime = timeStr[1];
		
		// lengthΪ5����Ҫȡ���Ķ���
		if (str.length == 5) {
			if(str[4].charAt(0) == 'C')
				cancel = true;
			else{
				System.out.println(">Error: the booking is invalid!");
				return null;
			}
		}
		Order o = new Order(str[0], str[1], startTime, endTime,
				str[3].charAt(0), cancel);
		
		// �ж�order�Ƿ�Ϸ�
		if (o.isOrderValid()) {
			return o;
		} else {
			System.out.println(">Error: the booking is invalid!");
			return null;
		}
	}

	// �������洢��OrderList��
	private void saveOrder(Order order) {
		if (!order.isOrderValid()) {
			System.out.println(">Error: the booking is invalid!");
			return;
		}
		if (isOrderCoflict(order)) {
			System.out
					.println(">Error: the booking conflicts with existing bookings!");
			return;
		}
		if (order.isOrderValid()) {
			try {
				list.addOrder(order);
				System.out.println(">Success: the booking is accepted!");
			} catch (OrderIsNotInvalidException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(">Somthing wrong");
		}
	}

	// ȡ������
	private void cancelOrder(Order cancelOrder) {
		if (!cancelOrder.isOrderValid()) {
			System.out.println(">Error: the cancel is invalid!");
			return;
		}
		if (!isOrderCanBeCancel(cancelOrder)) {
			System.out
					.println(">Error: the booking being cancelled does not exist!");
		} else {
			try {
				list.addOrder(cancelOrder);
				System.out.println(">Success: the cancel is accepted!");
			} catch (OrderIsNotInvalidException e) {
				e.printStackTrace();
			}
		}
	}

	public void dealWithOrder(String orderStr) {
		Order order = creatOrder(orderStr);
		if (order != null) {
			if (order.isCancel()) {
				cancelOrder(order);
			} else {
				saveOrder(order);
			}
		}
	}

	public void printAllOrdersAndFee() {
		TreeMap<String, Order>[] arr = list.getArr();
		char area = 'A';
		double fee_OneArea;
		double fee_All = 0;
		System.out.println("�������");
		System.out.println("---");
		for (int i = 0; i < arr.length; i++) {
			fee_OneArea = 0;
			System.out.println("���أ�" + (area++));
			Iterator<Map.Entry<String, Order>> iter = arr[i].entrySet()
					.iterator();

			while (iter.hasNext()) {
				Map.Entry<String, Order> entry = (Entry<String, Order>) iter
						.next();
				System.out.println(entry.getValue().orderStr());
				fee_OneArea += entry.getValue().fee();
			}
			System.out.println("С�ƣ�" + fee_OneArea);
			if (i < 3)
				System.out.println("");
			else
				System.out.println("---");
			fee_All += fee_OneArea;
		}
		System.out.println("�ܼƣ�" + fee_All);

	}

}
