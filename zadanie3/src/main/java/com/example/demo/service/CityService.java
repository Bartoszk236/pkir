package com.example.demo.service;

import com.example.demo.dto.CityRequest;
import com.example.demo.entity.City;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CityService {
    private final Map<Long, City> cities = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public City addCity(CityRequest request) {
        validateRequest(request);

        Long id = idGenerator.getAndIncrement();
        City city = new City(id, request.name().trim());
        cities.put(id, city);
        return city;
    }

    public List<City> getAllCities() {
        return new ArrayList<>(cities.values());
    }

    public City getCityById(Long id) {
        City city = cities.get(id);
        if (city == null) {
            throw new NoSuchElementException("City with id " + id + " not found");
        }
        return city;
    }

    public City updateCity(Long id, CityRequest request) {
        validateRequest(request);

        City existingCity = cities.get(id);
        if (existingCity == null) {
            throw new NoSuchElementException("City with id " + id + " not found");
        }

        existingCity.setName(request.name().trim());
        return existingCity;
    }

    public void deleteCity(Long id) {
        City removed = cities.remove(id);
        if (removed == null) {
            throw new NoSuchElementException("City with id " + id + " not found");
        }
    }

    private void validateRequest(CityRequest request) {
        if (request == null || request.name() == null || request.name().isBlank()) {
            throw new IllegalArgumentException("City name cannot be empty");
        }
    }
}
