
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
