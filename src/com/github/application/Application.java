package com.github.application;

import com.github.battleship.Location;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@RestController
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {

		ArrayList<ArrayList<Location>> test = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			ArrayList<Location> t1 = new ArrayList<>();
			for (int j = 0; j < 2; j++) {
				Location loc = new Location(new Random().nextInt(10), new Random().nextInt(10));
				t1.add(loc);
			}
			test.add(t1);
		}
		String json = new Gson().toJson(test);
		System.out.println(json);
		SpringApplication.run(Application.class, args);

	}

}