package com.souha.fizzbuzz;

import com.souha.fizzbuzz.core.FizzBuzzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static com.souha.fizzbuzz.utils.ConsoleOutputUtils.printLine;

@SpringBootApplication
public class Application implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private FizzBuzzService fizzBuzzService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner numberIn = new Scanner(System.in);
        System.out.println("Enter number between 1 and 100");
        int number = numberIn.nextInt();

        while (number > 100 || number < 1)
        {
            System.out.println("Enter number between 1 and 100");
            number = numberIn.nextInt();
        }

        logger.info("START");
        JSONObject output = new JSONObject();

        IntStream.range(1, number+1).forEach(n -> {
            output.put(n, fizzBuzzService.evalNumber(n));
            System.out.println(n + " : " + fizzBuzzService.evalNumber(n));
        });

        logger.info("END");
        try (FileWriter file = new FileWriter("numbers.json")) {

            file.write(output.toJSONString());
            file.flush();
            System.out.println("Results in numbers.json");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}