package cn.itcast.code.day24.ThreadLearn.ThreadGroupLearn;

public class MyRunnable implements Runnable{

    public MyRunnable(){

    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);

        }
    }
}
