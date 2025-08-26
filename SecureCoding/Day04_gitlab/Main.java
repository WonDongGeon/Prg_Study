package org.owasp.webgoat.vulnerable_components;

import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Main {
    public static void main(String[] args) throws IOException {

    	XStream xstream = new XStream(new DomDriver());

        // Register annotations or process classes manually
        xstream.processAnnotations(Contact.class);

        String xml = "<org.owasp.webgoat.vulnerable_components.ContactImpl><id>1</id><firstName>John</firstName><lastName>Doe</lastName><email>john.doe@example.com</email></org.owasp.webgoat.vulnerable_components.ContactImpl>";

        Contact contact = (Contact) xstream.fromXML(xml);

        System.out.println("ID: " + contact.getId());
        System.out.println("First Name: " + contact.getFirstName());
        System.out.println("Last Name: " + contact.getLastName());
        System.out.println("Email: " + contact.getEmail());
    }
}
