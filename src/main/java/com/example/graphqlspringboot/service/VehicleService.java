package com.example.graphqlspringboot.service;

import com.example.graphqlspringboot.dao.VehicleRepository;
import com.example.graphqlspringboot.dao.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository repository;

    @Transactional
    public Vehicle createVehicle(String type, String modelCode, String brandName, String launchDate) {
        return repository.save(Vehicle.builder()
                .type(type)
                .modelCode(modelCode)
                .brandName(brandName)
                .launchDate(LocalDate.parse(launchDate))
                .build());
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles(int count) {
        return repository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(long id) {
        return repository.findById(id);
    }
}
