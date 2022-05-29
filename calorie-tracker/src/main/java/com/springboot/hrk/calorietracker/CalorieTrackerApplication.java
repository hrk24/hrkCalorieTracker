package com.springboot.hrk.calorietracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CalorieTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalorieTrackerApplication.class, args);
		System.out.println("Welcome to HRK CALORIE TRACKER");
	}

}
