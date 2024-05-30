package ru.itmo.mobile_development_api.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itmo.mobile_development_api.entity.GadgetEntity;

@Data
@Builder
@AllArgsConstructor
public class RoomDto {


    private Integer id;
    private List<GadgetEntity> gadgets;

}
