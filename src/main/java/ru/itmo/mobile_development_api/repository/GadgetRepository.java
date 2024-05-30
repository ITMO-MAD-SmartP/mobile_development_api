package ru.itmo.mobile_development_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.mobile_development_api.entity.GadgetEntity;

public interface GadgetRepository extends JpaRepository<GadgetEntity, Integer> {


    @Query(nativeQuery = true,
            value = "SELECT * FROM sensors  " +
                    "LEFT JOIN sensors_in_room sir on sensors.id = sir.sensor_id " +
                    "WHERE sir.room_id = :roomId")
    List<GadgetEntity> findAllByRoomId(Integer roomId);

}
