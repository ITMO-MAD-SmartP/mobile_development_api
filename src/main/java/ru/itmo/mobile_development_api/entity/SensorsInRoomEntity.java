package ru.itmo.mobile_development_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@IdClass(SensorIdRoomIdPair.class)
@Table(name = "sensors_in_room")
public class SensorsInRoomEntity {


    @Id
    @Column(name = "sensor_id")
    private Integer sensorId;

    @Id
    @Column(name = "room_id")
    private Integer roomId;

}
