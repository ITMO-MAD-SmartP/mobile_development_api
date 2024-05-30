package ru.itmo.mobile_development_api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class GetGadgetStatusRequest {


    @JsonProperty("SESSION")
    private String session;

    @JsonProperty("GADGET_ID")
    private Integer gadgetId;


}
