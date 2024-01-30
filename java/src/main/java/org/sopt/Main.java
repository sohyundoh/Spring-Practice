package org.sopt;

import org.sopt.classes.Member;
import org.sopt.classes.Part;
import org.sopt.classes.Person;

public class Main {
    public static void main(String[] args) {
        Person.run();

        //Person 클래스의 객체 생성
        Person person = new Person("도소현", 24, "female");


        //Person 클래스 내부 메소드 호출
        person.walk();

        System.out.println(person.getName());

        person.setName("기요미><");

        System.out.println(person.getName());

        System.out.println(person.getInfo());

        //상속
        Member member = new Member("도소현", 24, "female", Part.SERVER);

        System.out.println(member.getInfo());
    }
}