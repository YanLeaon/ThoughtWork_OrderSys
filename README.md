#题目 羽毛球馆
##开发环境

语言环境：Java
本机测试运行环境：JDK7
开发工具：MyEclipse

##使用Java单元测试工具测试
单元测试类TestDemo中的test1()、test2()、test3()分别处理用例1，用例2和用例3
test4()方法用于测试键盘输入的其他用例
###测试用例1
#####输入：
abcdefghijklmnopqrst1234567890
U001 2016-06-02 22:00~22:00 A
U002 2017-08-01 19:00~22:00 A
U003 2017-08-02 13:00~17:00 B
U004 2017-08-03 15:00~16:00 C
U005 2017-08-05 09:00~11:00 D

#####分别输出：
	>Error: the booking is invalid!
    >Error: the booking is invalid!
    >Success: the booking is accepted!
    >Success: the booking is accepted!
    >Success: the booking is accepted!
    >Success: the booking is accepted!

#####继续输入空行：

#####输出：
	收入汇总
    ---
    场地：A
    2017-08-01 19:00~22:00 200.0元
    小计：200.0

    场地：B
    2017-08-02 13:00~17:00 200.0元
    小计：200.0

    场地：C
    2017-08-03 15:00~16:00 50.0元
    小计：50.0

    场地：D
    2017-08-05 09:00~11:00 80.0元
    小计：80.0
    ---
    总计：530.0



###测试用例2
#####输入：
U002 2017-08-01 19:00~22:00 A
U003 2017-08-01 18:00~20:00 A
U002 2017-08-01 19:00~22:00 A C
U002 2017-08-01 19:00~22:00 A C
U003 2017-08-01 18:00~20:00 A
U003 2017-08-02 13:00~17:00 B

#####分别输出：
	>Success: the booking is accepted!
	>Error: the booking conflicts with existing bookings!
	>Success: the cancel is accepted!
	>Error: the booking being cancelled does not exist!
	>Success: the booking is accepted!
	>Success: the booking is accepted!
***注：取消成功的输出为 >Success: the cancel is accepted!***
#####继续输入空行：

#####输出：
	收入汇总
    ---
    场地：A
    2017-08-01 18:00~20:00 160.0元
    2017-08-01 19:00~22:00 违约金100.0元
    小计：260.0

    场地：B
    2017-08-02 13:00~17:00 200.0元
    小计：200.0

    场地：C
    小计：0.0

    场地：D
    小计：0.0
    ---
    总计：460.0


###测试用例3
#####输入：
abcde fghijkl mnopqrs t1234567 890

#####输出：
	>Error: the booking is invalid!
#####分析：
该测试用例表明程序不允许非法的清单请求


###测试用例4
#####输入：
U003 20007-08-01 18:00~20:00 A

#####输出：
	>Error: the booking is invalid!
#####分析：
该测试用例表明程序不允许日期格式不合法


###测试用例5
#####输入：
U003 2017-08-01 18:01~20:00 A

#####输出：
	>Error: the booking is invalid!
#####分析：
该测试用例表明程序不允许时间非整点


###测试用例6
#####输入：
U003 2017-08-01 18:00~20:00 A
U003 2017-08-01 18:00~20:00 A D

#####输出：
    >Success: the booking is accepted!
	>Error: the booking is invalid!
#####分析：
该测试用例表明程序不允许订单的取消标识为其他内容

###测试用例8
#####输入：
U003 2017-08-01 9:00~12:00 A
U003 2017-08-01 9:00~12:00 B
U003 2017-08-01 9:00~12:00 C
U003 2017-08-01 9:00~12:00 D
U003 2017-08-01 9:00~12:00 E

#####输出：
	>Success: the booking is accepted!
    >Success: the booking is accepted!
    >Success: the booking is accepted!
    >Success: the booking is accepted!
    >Error: the booking is invalid!
#####分析：
该测试用例表明程序不允许订单的场地标识为除A、B、C、D外的其他标识

###测试用例9
#####输入：
U003 2017-08-01 9:00~12:00 B
U002 2017-08-01 9:00~12:00 B C

#####输出：
	>Success: the booking is accepted!
    >Error: the booking being cancelled does not exist!
#####分析：
该测试用例表明程序不允许用户取消其他用户订单

###测试用例10
#####输入：
U003 2017-08-01 22:00~24:00 B
U003 2017-08-01 08:00~09:00 C
U003 2017-08-01 12:00~09:00 D

#####输出：
	>Error: the booking is invalid!
	>Error: the booking is invalid!
	>Error: the booking is invalid!
#####分析：
该测试用例表明程序不允许时间为非营业时间，不允许开始时间晚于结束时间
