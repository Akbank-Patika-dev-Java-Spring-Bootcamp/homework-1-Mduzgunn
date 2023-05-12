package com.md.homework1.service;

import com.md.homework1.dto.CityDto;
import com.md.homework1.dto.request.CreateCityRequest;
import com.md.homework1.dto.request.UpdateCityRequest;
import com.md.homework1.exceprion.CityNotFoundException;
import com.md.homework1.mapper.CityMapper;
import com.md.homework1.model.City;
import com.md.homework1.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityService(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    protected City findCityById(String id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found with id " + id));
    }

    public CityDto getCityById(String id) {
        return cityMapper.cityToCityDto(findCityById(id));
    }

    public List<CityDto> getAllCities() {
        List<City> cityList = cityRepository.findAll();
        return cityMapper.cityToCityDto(cityList);
    }


    public CityDto createCity(CreateCityRequest createCityRequest) {
        City city = cityMapper.createCityRequestToCity(createCityRequest);
        return cityMapper.cityToCityDto(cityRepository.save(city));
    }

    public CityDto updateCity(String id, UpdateCityRequest updateCityRequest) {
        City city = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException("City not found with id " + id));
        city.setPresident(updateCityRequest.getPresident());

        return cityMapper.cityToCityDto(cityRepository.save(city));
    }


    public String deleteCityById(String id) {
        getCityById(id);
        cityRepository.deleteById(id);
        return "City deleted successfully with id " + id;
    }

}
