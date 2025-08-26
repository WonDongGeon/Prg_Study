package org.owasp.webgoat.vulnerable_components;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Test {
    public static void main(String[] args) {
        String xml = "<Person class='Person'>" +
                     "<name>홍길동</name>" +
                     "<age>30</age>" +
                     "</Person>";

        XStream xstream = new XStream();
        // 보안 설정: Person 클래스만 허용
        xstream.allowTypes(new Class[] { Person.class });
        // alias 설정 (선택)
        xstream.alias("Person", Person.class);
        // 역직렬화
        Person person = (Person) xstream.fromXML(xml);

        System.out.println("XML을 객체로 변환:");
        System.out.println("이름: " + person.getName());
        System.out.println("나이: " + person.getAge());
    }
}
