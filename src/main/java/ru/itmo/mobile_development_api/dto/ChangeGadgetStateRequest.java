package ru.itmo.mobile_development_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import ru.itmo.mobile_development_api.enums.Action;
import ru.itmo.mobile_development_api.enums.GadgetType;

@Data
@Builder
@AllArgsConstructor
public class ChangeGadgetStateRequest {

    @JsonProperty("SESSION")
    private String session;
    @JsonProperty("HOME_ID")
    private Integer homeId;
    @JsonProperty("GADGET_ID")
    private Integer gadgetId;
    @JsonProperty("GADGET_TYPE")
    private GadgetType gadgetType;
    @JsonProperty("ACTION")
    private Action action;
    @JsonProperty("VALUE")
    private String value;



}
