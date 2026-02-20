package com.example.demo;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {
    private static final Faker faker = new Faker();

    @GetMapping("/random-temp")
    public Map<String, Double> randomTemp() {
        return Map.of("temp", faker.random().nextDouble());
    }

    @GetMapping("/wind-direction")
    public Map<String, String> windDirection() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "west");
        map.put(2, "east");
        map.put(3, "north");
        map.put(4, "south");

        Integer random = faker.number().numberBetween(1, 4);
        return Map.of("direction", map.get(random));
    }
}
