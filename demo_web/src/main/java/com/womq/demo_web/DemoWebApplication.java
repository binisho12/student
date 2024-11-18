package com.womq.demo_web;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
public class DemoWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
	}
}
