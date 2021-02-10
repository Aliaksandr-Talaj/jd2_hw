package it.academy.pojos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@Component

public class Admin implements UserProfile {

    @Value("BloodyExecutor")
    private String name;

    @Override
    public void sendMessage() {
        System.out.println("You are banned!");
    }
}
