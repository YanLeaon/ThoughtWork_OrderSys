package cn.thoughtworks.homwork;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Order {
	private String usereId;
	private String bookDate;
	private String bookStartTime;
	private String bookEndTime;
	private char bookArea;
	private boolean cancel; // 是否取消

	public String getUsereId() {
		return usereId;
	}

	public String getBookDate() {
		return bookDate;
	}

	public String getBookDateAndStartTime() {
		return bookDate + bookStartTime;
	}

	public String getBookStartTime() {
		return bookStartTime;
	}

	public String getBookEndTime() {
		return bookEndTime;
	}

	public boolean isCancel() {
		return cancel;
	}

	public char getBookArea() {
		return bookArea;
	}

	Order(String userId, String bookDate, String bookStartTime,
			String bookEndTime, char bookArea, boolean cancel) {
		this.usereId = userId;
		this.bookDate = bookDate;
		this.bookStartTime = bookStartTime;
		this.bookEndTime = bookEndTime;
		this.bookArea = bookArea;
		this.cancel = cancel;
	}

	// 计算本条订单的费用
	public double fee() {
		return Fee.getFee(this);
	}
	
	/** 
	 * 判断组装的Order对象是否合法：时间是否为整点(订单的标记是否正确在组装前判断)
	 * @return 合法返回true
	 * */
	public boolean isOrderValid() {
		if (this.getBookDate() == null) {
			return false;
		}
		if (this.getBookArea() != 'A' && this.getBookArea() != 'B'
				&& this.getBookArea() != 'C' && this.getBookArea() != 'D') {
			return false;
		}
		if (this.getBookDate() != null) {
			String[] strs = this.getBookDate().split("-");
			if (strs[0].length() == 4
					&& (strs[1].length() == 1 || strs[1].length() == 2)
					&& strs[2].length() == 2) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
					sdf.parse(this.getBookDate());
				} catch (IllegalArgumentException | ParseException e) {
					return false;
				}
			} else
				return false;
		}
		if (this.getUsereId() == null) {
			return false;
		}
		if (this.getUsereId() != null) {
			String[] str;
			String[] str2;
			if (this.getBookEndTime() != null
					&& this.getBookStartTime() != null) {
				str = this.getBookStartTime().split(":");
				str2 = this.getBookEndTime().split(":");
				int startTimeHour = Integer.parseInt(str[0]);
				int endTimeHour = Integer.parseInt(str2[0]);
				if (startTimeHour >= endTimeHour || startTimeHour < 9
						|| endTimeHour > 22) {
					return false;
				} else
					return str[1].equals("00") && str2[1].equals("00");
			} else
				return false;
		}
		return true;
	}

	// 忽略日期、开始时间、是否为已取消订单的比较
	public boolean equalsCancelOrder(Order order) {
		if (this == order)
			return true;
		if (order == null)
			return false;
		if (getClass() != order.getClass())
			return false;
		Order other = order;
		if (bookArea != other.bookArea)
			return false;
		if (bookEndTime == null) {
			if (other.bookEndTime != null)
				return false;
		} else if (!bookEndTime.equals(other.bookEndTime))
			return false;
		if (usereId == null) {
			if (other.usereId != null)
				return false;
		} else if (!usereId.equals(other.usereId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookArea;
		result = prime * result
				+ ((bookDate == null) ? 0 : bookDate.hashCode());
		result = prime * result
				+ ((bookEndTime == null) ? 0 : bookEndTime.hashCode());
		result = prime * result
				+ ((bookStartTime == null) ? 0 : bookStartTime.hashCode());
		result = prime * result + (cancel ? 1231 : 1237);
		result = prime * result + ((usereId == null) ? 0 : usereId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (bookArea != other.bookArea)
			return false;
		if (bookDate == null) {
			if (other.bookDate != null)
				return false;
		} else if (!bookDate.equals(other.bookDate))
			return false;
		if (bookEndTime == null) {
			if (other.bookEndTime != null)
				return false;
		} else if (!bookEndTime.equals(other.bookEndTime))
			return false;
		if (bookStartTime == null) {
			if (other.bookStartTime != null)
				return false;
		} else if (!bookStartTime.equals(other.bookStartTime))
			return false;
		if (cancel != other.cancel)
			return false;
		if (usereId == null) {
			if (other.usereId != null)
				return false;
		} else if (!usereId.equals(other.usereId))
			return false;
		return true;
	}

	public String orderStr() {
		if(isCancel())
			return bookDate+ " " + bookStartTime + "~"+ bookEndTime + " "+ "违约金"+ this.fee() + "元";
		else
			return bookDate+ " " + bookStartTime + "~"+ bookEndTime + " "+ this.fee() + "元";
	}
	
	

}
