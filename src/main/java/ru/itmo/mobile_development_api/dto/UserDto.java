package ru.itmo.mobile_development_api.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    private List<HomeDto> homes;

}
