package ru.itmo.mobile_development_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.mobile_development_api.entity.SensorIdRoomIdPair;
import ru.itmo.mobile_development_api.entity.SensorsInRoomEntity;

public interface SensorsInRoomRepository extends JpaRepository<SensorsInRoomEntity, SensorIdRoomIdPair> {
}
