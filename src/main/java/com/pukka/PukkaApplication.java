package com.pukka;

import com.pukka.controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import static org.apache.commons.lang3.StringUtils.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@SpringBootApplication
@Profile("!test")
public class PukkaApplication implements CommandLineRunner {

	@Autowired
	private LoginController loginController;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application loaded. Please enter your input...");

		List<String> inputs = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = reader.readLine();
			while(isNotBlank(line)) {
				inputs.add(line);
				line = reader.readLine();
			}
		}

		inputs.stream().map(input -> {
			String result = loginController.login(input);
			if(!result.equals("error")) {
				result = input + "," + result;
			}
			return result;
		}).forEach(System.out::println);
	}

	public static void main(String args[]) throws Exception {
		SpringApplication.run(PukkaApplication.class, args);
	}

}
