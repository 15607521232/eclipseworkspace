package cn.itcast.code.day27.ReflectLearn;
/*
    反射：就是通过class文件对象，去使用该文件中的成员变量，构造方法，成员方法。

    Person p = new Person();
    p.使用

    要想这样使用，首先你必须得到class文件对象，其实也就是得到Class类的对象。
    Class类：
            成员变量	Field
            构造方法	Constructor
            成员方法	Method

    获取class文件对象的方式：
    A:Object类的getClass()方法
    B:数据类型的静态属性class
    C:Class类中的静态方法
            public static Class forName(String className)

    一般我们到底使用谁呢?
            A:自己玩	任选一种，第二种比较方便
            B:开发	第三种
                为什么呢?因为第三种是一个字符串，而不是一个具体的类名。这样我们就可以把这样的字符串配置到配置文件中。
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectLearn {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        //方式一
        PersonLearn p = new PersonLearn();
        Class c = p.getClass();

        PersonLearn p2 = new PersonLearn();
        Class c2 = p2.getClass();

        System.out.println(p == p2);
        System.out.println(c == c2);


        //方式2

        Class c3 = PersonLearn.class;
        System.out.println(int.class);
        System.out.println(c == c3);


        //方式3

        Class c4 = Class.forName("cn.itcast.code.day27.ReflectLearn.PersonLearn");
        System.out.println(c == c4);


        //反射获取构造方法并使用

        //获取字节码文件对象
        Class c5 = Class.forName("cn.itcast.code.day27.ReflectLearn.PersonLearn");

        //获取构造方法
        //public Constructor<?>[] getConstructors() throws SecurityException
        /*Constructor[] con = c5.getConstructors();
        for(Constructor cr:con){
            //public cn.itcast.code.day27.ReflectLearn.PersonLearn(java.lang.String,int,java.lang.String)
            //public cn.itcast.code.day27.ReflectLearn.PersonLearn()
            System.out.println(cr);
        }*/

        //获取单个构造方法
        //public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException,SecurityException
        Constructor con = c5.getConstructor();//返回一个 Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法。
        System.out.println(con);

        //public T newInstance(Object... initargs) throws InstantiationException, IllegalAccessException,IllegalArgumentException, InvocationTargetException
        //过调用此对象表示的构造方法来创建的新对象

        Object obj = con.newInstance();
        System.out.println(obj);

        PersonLearn pl = (PersonLearn)obj;
        pl.show();

        //需求：通过反射去获取该构造方法并使用
        System.out.println("通过反射去获取该构造方法并使用");

        // 获取带参构造方法对象
        Constructor cs = c5.getConstructor(String.class,int.class,String.class);

        //通过带参构造方法对象创建对象
        //public T newInstance(Object... initargs)
        Object objParam = cs.newInstance("liguang",25,"xian");
        System.out.println(objParam);


        //通过反射获取私有构造方法并使用
        System.out.println("通过反射获取私有构造方法并使用");


        //获取私有构造方法对象
        Constructor cPrivate = c5.getDeclaredConstructor(String.class);

        //该私有构造方法创建对象

        cPrivate.setAccessible(true);//值为true则指示反射的对象在使用时应该取消Java语言访问检查。
        Object onPrivate = cPrivate.newInstance("subiao");//IllegalAccessException:
        System.out.println(onPrivate);










    }
}