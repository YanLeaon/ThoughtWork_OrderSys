package cn.thoughtworks.homwork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fee {
	private static final int[] arrWorkDay = {30,30,30,50,50,50,50,50,50,80,80,60,60};
	private static final int[] arrWeekEnd = {40,40,40,50,50,50,50,50,50,60,60,60,60};
	
	public static boolean isWeekend(Order order) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(order.getBookDate());
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("输入的日期不合法");
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return true;
		}
		return false;
	}
	
	public static double getFee(Order order){
		double result = 0;
		String[] str = order.getBookStartTime().split(":");
		int startTime = Integer.parseInt(str[0]);
		str = order.getBookEndTime().split(":");
		int endTime = Integer.parseInt(str[0]);
		if(isWeekend(order)){
			for (int i = startTime - 9; i <= endTime - 9 - 1; i++) {
				result += arrWeekEnd[i];
			}
			if(order.isCancel()){
				result *= 0.25;
			}
		}else{
			for (int i = startTime - 9; i <= endTime - 9 - 1; i++) {
				result += arrWorkDay[i];
			}
			if(order.isCancel()){
				result *= 0.5;
			}
		}
		return result;
	}
	
	
}
