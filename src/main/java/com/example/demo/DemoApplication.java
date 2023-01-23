package com.example.demo;


import com.example.demo.config.Config;
import com.example.demo.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Communication communication = context.getBean("communication", Communication.class);
        List<String> allUsers = communication.getAllUsers();
        System.out.println(allUsers);
        communication.saveUser(new User(3L, "James", "Brown", (byte) 15));
        communication.updateUser(new User(3L, "Thomas", "Shelby", (byte) 30));
        communication.deleteUser(3L);

        System.out.println(Communication.result);
    }

}
