package cn.itcast.code.day24.ThreadLearn.ConsumersAndProducers;

/*public class ResourcesDemo {

    String name;
    int age;
    boolean flag; // 默认情况是没有数据，如果是true，说明有数据

}*/

//优化方案
public class ResourcesDemo {

    private String name;
    private int age;
    private boolean flag; // 默认情况是没有数据，如果是true，说明有数据

    public synchronized void set(String name, int age){
        //如果有设置数据，就等
        if(this.flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //设置数据
        this.name = name;
        this.age = age;

        //修改标记
        this.flag = true;
        this.notify();
    }

    public synchronized void get(){
        //如果没有数据，就等待
        if(!this.flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //获取数据
        System.out.println(this.name + "--" + this.age);

        //修改标记对
        this.flag = false;
        this.notify();
    }

}