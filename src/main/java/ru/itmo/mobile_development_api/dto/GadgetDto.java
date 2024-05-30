package ru.itmo.mobile_development_api.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GadgetDto {

    private Integer id;

    private String name;

    private Boolean state;

    private Double value;

}
