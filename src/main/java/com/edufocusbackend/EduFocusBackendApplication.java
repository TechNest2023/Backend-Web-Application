package com.edufocusbackend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EduFocusBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduFocusBackendApplication.class, args);
    }

    @GetMapping("/Message")
    public String message(){
        return "WELCOME FROM JAVA SPRING BOOT TO AZURE - EDUFOCUS";
    }
}
