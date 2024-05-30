package ru.itmo.mobile_development_api.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GetGraphInfoResponse {

    private Integer requestId;

    private List<TimeValuePair> values;

}