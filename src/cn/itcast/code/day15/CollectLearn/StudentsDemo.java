package cn.itcast.code.day15.CollectLearn;

import java.util.Objects;

public class StudentsDemo implements Comparable<StudentsDemo> {


    private String name;
    private int age;
    private String gender;

    public StudentsDemo(){};

    public StudentsDemo(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentsDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsDemo that = (StudentsDemo) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    @Override
    public int compareTo(StudentsDemo o) {
        //返回什么需要根据排序规则
        int num= this.age - o.age;
        int num2  = num ==0?this.name.compareTo(o.name) : num;
        return num2;
    }
}
