package com.md.homework1.dto.converter;

import com.md.homework1.dto.CityDto;
import com.md.homework1.model.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityDtoConverter {
    public List<CityDto> convertToCityDtoList(List<City> cityList) {
        return cityList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public CityDto convert(City from) {
        return new CityDto(
                from.getId(),
                from.getName(),
                from.getPresident()
        );
    }
}
