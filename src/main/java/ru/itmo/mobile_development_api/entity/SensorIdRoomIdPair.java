package ru.itmo.mobile_development_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@IdClass(SensorIdRoomIdPair.class)
public class SensorIdRoomIdPair {


    @Id
    @Column(name = "sensor_id")
    private Integer sensorId;

    @Id
    @Column(name = "room_id")
    private Integer roomId;
}
