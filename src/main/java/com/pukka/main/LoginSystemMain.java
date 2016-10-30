package com.pukka.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.apache.commons.lang3.StringUtils.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LoginSystemMain implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application loaded. Enter your input...");

		List<String> lines = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = reader.readLine();
			while(isNotBlank(line)) {
				lines.add(line);
				line = reader.readLine();
			}
		}

		System.out.println("lines:" + lines);
	}

	public static void main(String args[]) throws Exception {
		SpringApplication.run(LoginSystemMain.class, args);
	}

}
