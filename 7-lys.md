# 7 Java后端

> **开冲！！！**

---

##### Java基础学习（痛苦面具） —— 《Java从入门到精通》 && 狂神视频

> **与c++相同部分直接照搬**

- java.util.Arrays类

  ```java
  import java.util.Arrays;
  // 填充数组
      fill(int[] a,int value);
      fill(int[] a,int fromindex,int toindex,int value);
  
  // 升序排序
  	Arrays.sort(object);
          
  // 复制数组
  	copyOf(arr,int newlenght);
      copyOfRange(arr,int fromindex,int toindex);
          
  // 搜索数据，返回索引值
      binarySearch(Object[] a,Object key);
      binarySearch(Object[] a,int fromindex,int toindex,Object key);
  ```

> **视频看了20多集（来不及了就自己去看书了）**

<img src="1.png" width = 600>

> **书看到143页（来不及了就直接去凹多线程了）**[^1]

<img src="2.png" width = 600>

> **发现我的书上有多线程！**
>
> <img src="3.png" width = 600>
>
> 然后读完了发现不仅一知半解而且书上几乎没讲 ``wait()`` 与 ``notify()`` (Ｔ▽Ｔ)

---

##### 不死心的我开始查博客

> **绝望的是搜多线程大部分都是用``sleep()``和``start()``	 的(〃＞皿＜)**

> **终于找到一篇**
>
> <img src = "4.png" width = 400>
>
> **然后盯着这篇博客盯了三天……**[^2]

> **盯了三天没看出名堂……**
>
> **试图将这个代码copy到自己电脑上运行试试——无法运行！！！**

> **又去翻了翻CSDN上的多线程文章(包括招新题上的)，勉强看了个半懂:**

```java
// 创建线程
	// 直接继承Thread类
class Text extends Thread{
    @Override
    public void run(){
    }
}
Text t1 = new Text();
ti.start();
	// 采用Runnable接口
class Text implements Runnable{
    @Override
    public void run(){
    }
}
Text text = new Text();
Thread t2 = new Thread(text);
t2.start();

// 线程栈
	// 新建、就绪、运行、阻塞、死亡

// 线程交互（wait and notify）
	// 用在 synchronized 的程序块中
	// 是 Object 类的
	// wait 要用 try-catch 语句，休眠线程并释放锁
	// notify 只是随机唤醒一个线程进入就绪状态，不会运行线程
	// 对象锁
```



> **那，开码？**

---

##### 尝试与错误

- 搭建框架

> 基础想法：
>
> 创建一个People类作为父类，下面设两个子类
>
> 模式化语块在父类中完成，子类只是负责协调语块的输出顺序
>
> 子类继承People类并使用Runnable接口，重载run()方法
>
> 输完一段话就进行wait，等待唤醒



> 结果:
> <img src = "5.png" width = 900>
> 程序根本无法运行！！！
>
> 我以为是vs code的问题，去网上搜报错说是定义了已有的类？
>
> 明明我也没有在网上找到People已经被定义的证据（期间重新安装了2次vs code）
>
> 然后我改成了People_就好了……



- 试运行

> 高兴的我马上运行程序
>
> 然后发现wait的线程根本醒不过来
>
> (当时先试着把run()设置成了synchronized方法，又删去了并定义synchronized程序块，对象锁是this)
>
> <img src = "6.png" width = 900>
>
> 去网上找要不就是代码没学的东西太多看不懂
>
> 要不就是设计的思路完全不一样，根本无法借鉴
>
> 我就只能和疯了一样去盯着别人的样例代码(30多页的百度文库)，并试图理解里面的新东西(｀Д´*)



- 重复线程

> 继续去查资料
>
> 网上说是由于当前的线程还占用着锁，需要等当前线程运行结束了才能让下个线程启动
>
> 我自己这个程序怎么还是老样子呢？
>
> 后来经焦友提醒，改成了同一个对象锁
>
> 我试了试，果然是这样！[^3]
>
> <img src = "7.png" width = 900>
>
> 出现了没有打出过的字样！



> 那问题来了
>
> 既然我要结束线程来释放锁，下次运行线程时不是又要重头开始了吗(当时不知道不能start两次)
>
> 自作聪明的我找到了方法：
>
> 用一个全局变量来控制线程运行的次数
>
> 用if来控制线程执行的代码，如下：
>
> <img src = "8.png" width = 700>
>
> (之前是用的父类的变量作为锁，经过询问后现在已经改成了Dome1的一个变量作为锁)



> 怎么把线程启动两次呢？
>
> 当然是两个start啦——不行？
>
> 哦，原来一个线程不能被启动两次
>
> 然后去百度上找到了start()-join()的重复运行方法：
>
> <img src = "9.png" width = 900>
>
> 没用，卡死~~~



- 功成

> 就在我一筹莫展之际
>
> 我突然想起wait()会导致当前线程休眠并***<u>! 释 ! 放 ! 锁 !</u>***
>
> 并且之前是因为对象锁不一样的问题才不成功……
>
> 我试着把程序改成了这个形式
>
> ```java
> notify();
> try{
>     Dome1.obj.wait();
> }catch(...){
>     ...
> }
> ```
>
> 运行试试？
>
> 成功了！！！！！！
>
> <img src = "10.png" width = 900>
>
> 真的感动~



> 最后才发现我的第一个版本改一个对象锁就是对的o(TωT)o
>
> 绕了一大圈才绕回去(Ｔ▽Ｔ) 



---

##### 聊天室

> 下次一定



---

##### 一些小感想

- java面向对象的特点与和其他语言的区别

> 经过我的感觉，java中的个体基本都是用类来表示的，在类中有自己的方法，感觉有点像生物学的类、属、种一样，层层分下来很有逻辑性，操作都是针对对象进行操作，但我操作习惯了函数对类的操作不是很习惯。相比起来c语言只有struct的功能比较类似，但是没有构造函数；c++中虽然struct有构造函数，也有class类，但基本不会很深入的去使用（对我来说）。

- java线程同步控制

> 多线程的实质还是单线程，只不过切换得很快像是同时进行的罢了，通过对这个线程切换的操作就实现了线程的同步控制。

- 终末感受

> 到这里，焦糖的招新题对我来说就到了尾声。虽然有可能无法入选，但这期间我还是学会了许多东西，想想那些挑灯夜战的晚上，查询资料时的抓狂，也许也不失为一种快乐，一种成长。
>
> 所以，再见，下次见。



---

##### 代码备份



```java

public class Dome1 {
    public static Object obj = new Object();
    // public static int cnt = 0;

    public static void main(String[] args) {

        JoJo JoJo = new JoJo("JoJo ", 18, "男", "唱、跳、rap、篮球、欧拉");
        Dio Dio = new Dio("Dio ", 108, "unknown", "唱、跳、rap、篮球、JoJo");

        Thread t1 = new Thread(JoJo);
        Thread t2 = new Thread(Dio);

        t1.start();
        t2.start();

    }
}

class People_ {
    public String name, sex, love;
    public int age;

    public People_() {
    }

    public People_(String name, int age, String sex, String love) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.love = love;
    }

    public void say_hello(int times) {
        if (times == 1) {
            System.out.println(name + ": 你好，我叫" + name + ",很高兴认识你");
        } else {
            System.out.println(name + ": 你好，我叫" + name + ",我也很高兴认识你");
        }
    }

    public void ask_age(int times) {
        if (times == 1) {
            System.out.println(name + ": 你今年多少岁了？");
        } else {
            System.out.println(name + ": 你呢？");
        }
    }

    public void reply_age() {
        System.out.println(name + ": 我今年" + age);
    }

    public void reply_sex() {
        System.out.println(name + ": 我是" + sex + "的");
    }

    public void ask_love(int times) {
        if (times == 1) {
            System.out.println(name + ": 你平时爱好什么呢？");
        } else {
            System.out.println(name + ": 你呢？");
        }
    }

    public void reply_love() {
        System.out.println(name + ": 我喜欢" + love);
    }

    public void bye(int times) {
        if (times == 1) {
            System.out.println(name + ": 拜拜！下次再见！");
        } else {
            System.out.println(name + ": bye!");
        }
    }

    public void busy() {
        System.out.println(name + ": 好巧，不知不觉已经聊了怎么久了，我还有点事，先走了。");
    }
}

class Dio extends People_ implements Runnable {
    public Dio(String name, int age, String sex, String love) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.love = love;
    }

    @Override
    public void run() {
        synchronized (Dome1.obj) {
            try {
                Dome1.obj.wait(2000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            say_hello(2);
            try {
                Dome1.obj.wait(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            ask_age(1);
            Dome1.obj.notifyAll();
            try {
                Dome1.obj.wait();
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            try {
                Dome1.obj.wait(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            reply_age();
            try {
                Dome1.obj.wait(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            ask_love(1);
            Dome1.obj.notifyAll();
            try {
                Dome1.obj.wait();
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            try {
                Dome1.obj.wait(500);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            reply_love();
            try {
                Dome1.obj.wait(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            busy();
            try {
                Dome1.obj.wait(500);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            bye(1);
            Dome1.obj.notifyAll();

        }
        // System.out.println("end");
    }
}

class JoJo extends People_ implements Runnable {
    public JoJo(String name, int age, String sex, String love) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.love = love;
    }

    @Override
    public void run(){
        synchronized(Dome1.obj){
            say_hello(1);
            try {
                Dome1.obj.wait();
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            try {
                Dome1.obj.wait(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            reply_age();
            try {
                Dome1.obj.wait(500);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            ask_age(2);
            Dome1.obj.notifyAll();
            try {
                Dome1.obj.wait();
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            try {
                Dome1.obj.wait(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            reply_love();
            try {
                Dome1.obj.wait(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            ask_love(2);
            Dome1.obj.notifyAll();

            try {
                Dome1.obj.wait();
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            try {
                Dome1.obj.wait(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            bye(2);
        }
    }
}

```

















---

[^1]: Java 的内容太多了!!!
[^2]: 之前跳过的东西太多了。。。

[^3]: 此处已经修改了对象锁的变量





