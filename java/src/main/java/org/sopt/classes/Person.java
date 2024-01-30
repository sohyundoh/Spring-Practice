package org.sopt.classes;

public class Person {
    private String name;
    private int age;
    private String sex;

    public void walk() {
        System.out.println("사람이 걷습니다");
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, int age) {
        this(name, age, "unknown");
    }
    public String getName() {
        return this.name;
    }

    public String getInfo() {
        return "이름: " + this.name + "나이: " + this.age + "성별: " + this.sex;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static void run() {
        System.out.println("사람이 뜁니다.");
    }
}
