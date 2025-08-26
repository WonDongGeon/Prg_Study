package org.owasp.webgoat.vulnerable_components;
import java.io.Serializable;

import com.thoughtworks.xstream.XStream;

public class XStreamExample{
    public static void main(String[] args) {
    	/*
    	// 객체 생성
        Person person = new Person("홍길동", 30);
        
        // XStream 객체 생성
        XStream xstream = new XStream();
        
        // 객체를 XML로 변환
        String xml = xstream.toXML(person);
        
        System.out.println("객체를 XML로 변환:");
        System.out.println(xml);
        */
        
        // XML 문자열 -> 객체로 변환
    	/*
        String xml = "<org.owasp.webgoat.vulnerable_components.Person>" +
                     "  <name>홍길동</name>\n" +
                     "  <age>30</age>\n" +
                     "</org.owasp.webgoat.vulnerable_components.Person>";
        */
    	
    	String xml = "<person class='Person'>" +
    			"<interface>org.owasp.webgoat.vulnerable_components.Person</interface>"+
                "  <name>홍길동</name>\n" +
                "  <age>30</age>\n" +
                "</person>";
    	
        // XStream 객체 생성
        XStream xstream = new XStream();
        
        // XML을 객체로 변환
        Person person = (Person) xstream.fromXML(xml);
        
        // 객체 출력
        System.out.println("XML을 객체로 변환:");
        System.out.println("이름: " + person.getName());
        System.out.println("나이: " + person.getAge());
        
    }
}

// Person 클래스 (위와 동일)
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
}
