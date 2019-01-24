package org.javahotfix.oom.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.javahotfix.oom")
public class OomDemoSpringBootApp {
	public static void main(String args[]) {
		SpringApplication.run(OomDemoSpringBootApp.class, args);
	}
}
