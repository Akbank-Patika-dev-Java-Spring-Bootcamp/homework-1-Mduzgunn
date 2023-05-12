package com.md.homework1.controller;

import com.md.homework1.dto.CityDto;
import com.md.homework1.dto.request.CreateCityRequest;
import com.md.homework1.dto.request.UpdateCityRequest;
import com.md.homework1.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCities() {
        List<CityDto> cityDtoList = cityService.getAllCities();
        return ResponseEntity.ok(cityDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable String id) {
        CityDto cityDto = cityService.getCityById(id);
        return ResponseEntity.ok(cityDto);
    }

    @PostMapping
    public ResponseEntity<CityDto> createCity(@RequestBody CreateCityRequest createCityRequest) {
        return ResponseEntity.ok(cityService.createCity(createCityRequest));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CityDto> updateCity(@PathVariable String id, @RequestBody UpdateCityRequest updateCityRequest) {
        return ResponseEntity.ok(cityService.updateCity(id, updateCityRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCityById(@PathVariable String id) {
        return ResponseEntity.ok(cityService.deleteCityById(id));
    }

}
