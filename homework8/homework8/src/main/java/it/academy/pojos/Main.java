package it.academy.pojos;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ActiveProfile activeProfile = context.getBean("activeProfile", ActiveProfile.class);


        activeProfile.printMessage();

        context.close();
    }

}
