package ir.ezbudget.dto;

import ir.ezbudget.entity.City;
import ir.ezbudget.entity.Province;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CityDto {

    private String code;
    private String name;
    private Province province;
    private List<CustomerDto> customers;

    public static City dtoToEntity(CityDto cityDto) {
        City city = new City();
        city.setCode(cityDto.getCode());
        city.setName(cityDto.getName());
        city.setProvince(cityDto.getProvince());
        city.setCustomers(cityDto.getCustomers().stream().map(CustomerDto::dtoToEntity).collect(Collectors.toList()));

        return city;
    }

    public static CityDto entityToDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setCode(city.getCode());
        cityDto.setName(city.getName());
        cityDto.setProvince(city.getProvince());
        cityDto.setCustomers(city.getCustomers().stream().map(CustomerDto::entityToDto).collect(Collectors.toList()));

        return cityDto;
    }

}
