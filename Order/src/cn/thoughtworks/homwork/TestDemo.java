package cn.thoughtworks.homwork;

import java.util.Scanner;

import org.junit.Test;

public class TestDemo {
	/*
	 * @Test public void testisCancelValid() throws OrderIsNotInvalidException{
	 * Order order = new Order("yanglei", "2017-09-10", "11:00", "14:00", 'A',
	 * false); Order order2 = new Order("yanglei", "2017-09-10", "11:00",
	 * "14:00", 'A', true); OrderList.getOrderList().addOrder(order); //
	 * System.out.println(OrderList.getOrderList().findOrder(order)); Deal_Order
	 * d = new Deal_Order(); System.out.println(d.isCancelValid(order2)); }
	 */

	/*
	 * @Test public void test() throws OrderIsNotInvalidException{ Order order =
	 * new Order("yanglei", "2017-09-10", "11:00", "14:00", 'A', false); Order
	 * order2 = new Order("yanglei", "2017-09-10", "12:00", "15:00", 'A',
	 * false); OrderList.getOrderList().addOrder(order); //
	 * System.out.println(OrderList.getOrderList().findOrder(order)); Deal_Order
	 * d = new Deal_Order(); System.out.println(d.isOrderCoflict(order2)); }
	 */

	/*
	 * @Test public void testisOrderValid() throws OrderIsNotInvalidException{
	 * Order order = new Order("yanglei", "2017-09-11", "9:00", "15:00", 'A',
	 * false); // System.out.println("isOrderValid"+order.isOrderValid());
	 * System.out.println("fee:"+order.fee()); }
	 */

	/*
	 * @Test public void test1(){ OrderList list = OrderList.getOrderList();
	 * Order order = new Order("yanglei", "2017-09-10", "11:00", "14:00", 'A',
	 * false); Order order2 = new Order("yanglei", "2017-09-10", "14:00",
	 * "15:00", 'A', false); Order order3 = new Order("yanglei", "2017-09-10",
	 * "14:00", "15:00", 'A', true); list.addOrder(order);
	 * list.addOrder(order2); Deal_Order d = new Deal_Order();
	 * System.out.println(d.isOrderCoflict(order2));
	 * System.out.println(d.isOrderCanBeCancel(order3)); }
	 */

	@Test
	public void test1() {
		Deal_Order deal = new Deal_Order();
		deal.dealWithOrder("abcdefghijklmnopqrst1234567890");
		deal.dealWithOrder("U001 2016-06-02 22:00~22:00 A");
		deal.dealWithOrder("U002 2017-08-01 19:00~22:00 A");
		deal.dealWithOrder("U003 2017-08-02 13:00~17:00 B");
		deal.dealWithOrder("U004 2017-08-03 15:00~16:00 C");
		deal.dealWithOrder("U005 2017-08-05 09:00~11:00 D");
		deal.printAllOrdersAndFee();
	}
	
	@Test
	public void test2() {
		Deal_Order deal = new Deal_Order();
		deal.dealWithOrder("U002 2017-08-01 19:00~22:00 A");
		deal.dealWithOrder("U003 2017-08-01 18:00~20:00 A");
		deal.dealWithOrder("U002 2017-08-01 19:00~22:00 A C");
		deal.dealWithOrder("U002 2017-08-01 19:00~22:00 A C");
		deal.dealWithOrder("U003 2017-08-01 18:00~20:00 A");
		deal.dealWithOrder("U003 2017-08-02 13:00~17:00 B");
		deal.printAllOrdersAndFee();
	}
	
	@Test
	public void test3() {
		Deal_Order deal = new Deal_Order();
		deal.dealWithOrder("abcde fghijkl mnopqrs t1234567 890");
		deal.dealWithOrder("U003 20007-08-01 18:00~20:00 A");
		deal.dealWithOrder("U002 2017-08-01 19:00~22:00 B C");
		deal.dealWithOrder("U003 2017-08-01 18:00~20:00 A");
		deal.dealWithOrder("U003 2017-08-01 18:00~20:00 A D");
		deal.dealWithOrder("U003 2017-08-01 18:01~20:00 A");
		deal.dealWithOrder("U003 2017-08-01 20:00~21:00 A");
		deal.dealWithOrder("U003 2017-08-01 22:00~24:00 B");
		deal.dealWithOrder("U003 2017-08-01 9:00~12:00 A");
		deal.dealWithOrder("U003 2017-08-01 9:00~12:00 B");
		deal.dealWithOrder("U003 2017-08-01 9:00~12:00 C");
		deal.dealWithOrder("U003 2017-08-01 9:00~12:00 D");
		deal.dealWithOrder("U003 2017-08-01 9:00~12:00 E");
		deal.dealWithOrder("U002 2017-08-01 21:00~22:00 B");
		deal.dealWithOrder("U003 2017-08-01 21:00~22:00 B C");
		deal.dealWithOrder("U004 2017-08-01 21:00~22:00 B");
		deal.dealWithOrder("U003 2017-08-01 18:00~20:00 C");
		deal.dealWithOrder("U003 2017-08-01 18:00~20:00 D");
		deal.dealWithOrder("U003 2017-08-02 14:00~09:00 D");
		deal.printAllOrdersAndFee();
	}
	
	@Test
	public void test4() {
		Deal_Order deal = new Deal_Order();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while(!str.equals("")){
			deal.dealWithOrder(str);
			str = sc.nextLine();
		}
		deal.printAllOrdersAndFee();
	}
	
	

}
