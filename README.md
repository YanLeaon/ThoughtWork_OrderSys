<h1 id="题目-羽毛球馆"><a name="题目-羽毛球馆" href="#题目-羽毛球馆"></a>题目 羽毛球馆</h1>
<h2 id="开发环境"><a name="开发环境" href="#开发环境"></a>开发环境</h2>
<p>语言环境：Java<br>本机测试运行环境：JDK7<br>开发工具：MyEclipse</p>
<h2 id="使用java单元测试工具测试"><a name="使用java单元测试工具测试" href="#使用java单元测试工具测试"></a>使用Java单元测试工具测试</h2>
<p>单元测试类TestDemo中的test1()、test2()、test3()分别处理用例1，用例2和用例3<br>test4()方法用于测试键盘输入的其他用例</p>
<h3 id="测试用例1"><a name="测试用例1" href="#测试用例1"></a>测试用例1</h3>
<h5 id="输入："><a name="输入：" href="#输入："></a>输入：</h5>
<p>abcdefghijklmnopqrst1234567890<br>U001 2016-06-02 22:00~22:00 A<br>U002 2017-08-01 19:00~22:00 A<br>U003 2017-08-02 13:00~17:00 B<br>U004 2017-08-03 15:00~16:00 C<br>U005 2017-08-05 09:00~11:00 D</p>
<h5 id="分别输出："><a name="分别输出：" href="#分别输出："></a>分别输出：</h5>
<pre><code>&gt;Error: the booking is invalid!
&gt;Error: the booking is invalid!
&gt;Success: the booking is accepted!
&gt;Success: the booking is accepted!
&gt;Success: the booking is accepted!
&gt;Success: the booking is accepted!
</code></pre><h5 id="继续输入空行："><a name="继续输入空行：" href="#继续输入空行："></a>继续输入空行：</h5>
<h5 id="输出："><a name="输出：" href="#输出："></a>输出：</h5>
<pre><code>收入汇总
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
</code></pre><h3 id="测试用例2"><a name="测试用例2" href="#测试用例2"></a>测试用例2</h3>
<h5 id="输入："><a name="输入：" href="#输入："></a>输入：</h5>
<p>U002 2017-08-01 19:00~22:00 A<br>U003 2017-08-01 18:00~20:00 A<br>U002 2017-08-01 19:00~22:00 A C<br>U002 2017-08-01 19:00~22:00 A C<br>U003 2017-08-01 18:00~20:00 A<br>U003 2017-08-02 13:00~17:00 B</p>
<h5 id="分别输出："><a name="分别输出：" href="#分别输出："></a>分别输出：</h5>
<pre><code>&gt;Success: the booking is accepted!
&gt;Error: the booking conflicts with existing bookings!
&gt;Success: the cancel is accepted!
&gt;Error: the booking being cancelled does not exist!
&gt;Success: the booking is accepted!
&gt;Success: the booking is accepted!
</code></pre><p><strong><em>注：取消成功的输出为 &gt;Success: the cancel is accepted!</em></strong></p>
<h5 id="继续输入空行："><a name="继续输入空行：" href="#继续输入空行："></a>继续输入空行：</h5>
<h5 id="输出："><a name="输出：" href="#输出："></a>输出：</h5>
<pre><code>收入汇总
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
</code></pre><h3 id="测试用例3"><a name="测试用例3" href="#测试用例3"></a>测试用例3</h3>
<h5 id="输入："><a name="输入：" href="#输入："></a>输入：</h5>
<p>abcde fghijkl mnopqrs t1234567 890</p>
<h5 id="输出："><a name="输出：" href="#输出："></a>输出：</h5>
<pre><code>&gt;Error: the booking is invalid!
</code></pre><h5 id="分析："><a name="分析：" href="#分析："></a>分析：</h5>
<p>该测试用例表明程序不允许非法的清单请求</p>
<h3 id="测试用例4"><a name="测试用例4" href="#测试用例4"></a>测试用例4</h3>
<h5 id="输入："><a name="输入：" href="#输入："></a>输入：</h5>
<p>U003 20007-08-01 18:00~20:00 A</p>
<h5 id="输出："><a name="输出：" href="#输出："></a>输出：</h5>
<pre><code>&gt;Error: the booking is invalid!
</code></pre><h5 id="分析："><a name="分析：" href="#分析："></a>分析：</h5>
<p>该测试用例表明程序不允许日期格式不合法</p>
<h3 id="测试用例5"><a name="测试用例5" href="#测试用例5"></a>测试用例5</h3>
<h5 id="输入："><a name="输入：" href="#输入："></a>输入：</h5>
<p>U003 2017-08-01 18:01~20:00 A</p>
<h5 id="输出："><a name="输出：" href="#输出："></a>输出：</h5>
<pre><code>&gt;Error: the booking is invalid!
</code></pre><h5 id="分析："><a name="分析：" href="#分析："></a>分析：</h5>
<p>该测试用例表明程序不允许时间非整点</p>
<h3 id="测试用例6"><a name="测试用例6" href="#测试用例6"></a>测试用例6</h3>
<h5 id="输入："><a name="输入：" href="#输入："></a>输入：</h5>
<p>U003 2017-08-01 18:00~20:00 A<br>U003 2017-08-01 18:00~20:00 A D</p>
<h5 id="输出："><a name="输出：" href="#输出："></a>输出：</h5>
<pre><code>&gt;Success: the booking is accepted!
&gt;Error: the booking is invalid!
</code></pre><h5 id="分析："><a name="分析：" href="#分析："></a>分析：</h5>
<p>该测试用例表明程序不允许订单的取消标识为其他内容</p>
<h3 id="测试用例8"><a name="测试用例8" href="#测试用例8"></a>测试用例8</h3>
<h5 id="输入："><a name="输入：" href="#输入："></a>输入：</h5>
<p>U003 2017-08-01 9:00~12:00 A<br>U003 2017-08-01 9:00~12:00 B<br>U003 2017-08-01 9:00~12:00 C<br>U003 2017-08-01 9:00~12:00 D<br>U003 2017-08-01 9:00~12:00 E</p>
<h5 id="输出："><a name="输出：" href="#输出："></a>输出：</h5>
<pre><code>&gt;Success: the booking is accepted!
&gt;Success: the booking is accepted!
&gt;Success: the booking is accepted!
&gt;Success: the booking is accepted!
&gt;Error: the booking is invalid!
</code></pre><h5 id="分析："><a name="分析：" href="#分析："></a>分析：</h5>
<p>该测试用例表明程序不允许订单的场地标识为除A、B、C、D外的其他标识</p>
<h3 id="测试用例9"><a name="测试用例9" href="#测试用例9"></a>测试用例9</h3>
<h5 id="输入："><a name="输入：" href="#输入："></a>输入：</h5>
<p>U003 2017-08-01 9:00~12:00 B<br>U002 2017-08-01 9:00~12:00 B C</p>
<h5 id="输出："><a name="输出：" href="#输出："></a>输出：</h5>
<pre><code>&gt;Success: the booking is accepted!
&gt;Error: the booking being cancelled does not exist!
</code></pre><h5 id="分析："><a name="分析：" href="#分析："></a>分析：</h5>
<p>该测试用例表明程序不允许用户取消其他用户订单</p>
<h3 id="测试用例10"><a name="测试用例10" href="#测试用例10"></a>测试用例10</h3>
<h5 id="输入："><a name="输入：" href="#输入："></a>输入：</h5>
<p>U003 2017-08-01 22:00~24:00 B<br>U003 2017-08-01 08:00~09:00 C<br>U003 2017-08-01 12:00~09:00 D</p>
<h5 id="输出："><a name="输出：" href="#输出："></a>输出：</h5>
<pre><code>&gt;Error: the booking is invalid!
&gt;Error: the booking is invalid!
&gt;Error: the booking is invalid!
</code></pre><h5 id="分析："><a name="分析：" href="#分析："></a>分析：</h5>
<p>该测试用例表明程序不允许时间为非营业时间，不允许开始时间晚于结束时间</p>
