package com.reto2;

import com.reto2.repository.crud.GadgetInterface;
import com.reto2.repository.crud.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2Application implements CommandLineRunner {
    @Autowired
    private GadgetInterface gadgetInterface;
    @Autowired
    private UserInterface userInterface;
    public static void main(String[] args) {
        SpringApplication.run(Reto2Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        gadgetInterface.deleteAll();
        userInterface.deleteAll();
    }
}
