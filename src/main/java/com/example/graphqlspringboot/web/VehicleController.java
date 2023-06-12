package com.example.graphqlspringboot.web;

import com.example.graphqlspringboot.dao.entity.Vehicle;
import com.example.graphqlspringboot.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @MutationMapping
    @Transactional
    public Vehicle createVehicle(@Argument String type, @Argument String modelCode,
                                 @Argument String brandName, @Argument String launchDate) {
        return service.createVehicle(type, modelCode, brandName, launchDate);
    }

    @QueryMapping
    @Transactional(readOnly = true)
    public List<Vehicle> getVehicles(@Argument int count){
        return service.getAllVehicles(count);
    }

    @QueryMapping
    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(@Argument long id){
        return service.getVehicle(id);
    }
}
