package ru.itmo.mobile_development_api.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TimeValuePair {

    private LocalDateTime time;
    private Double value;
}
