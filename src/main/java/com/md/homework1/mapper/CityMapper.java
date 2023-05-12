package com.md.homework1.mapper;


import com.md.homework1.dto.CityDto;
import com.md.homework1.dto.request.CreateCityRequest;
import com.md.homework1.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDto cityToCityDto(City city);

    City createCityRequestToCity(CreateCityRequest createCityRequest);

    List<CityDto> cityToCityDto(List<City> cityList);

}
