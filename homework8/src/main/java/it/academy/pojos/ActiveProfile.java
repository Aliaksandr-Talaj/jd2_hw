package it.academy.pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ActiveProfile {


    @Autowired
    @Qualifier("admin")

    private UserProfile userProfile;


    public void printMessage() {
        System.out.println("A new message from " +
                userProfile.getClass().getSimpleName() + " " +
                userProfile.getName() + ":");
        userProfile.sendMessage();
    }
}
