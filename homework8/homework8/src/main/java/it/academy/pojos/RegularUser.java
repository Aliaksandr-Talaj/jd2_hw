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
public class RegularUser implements UserProfile {
    @Value("Senya")
    private String name;

    @Override
    public void sendMessage() {
        System.out.println("LOL!");
    }
}
