package ru.itmo.mobile_development_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.mobile_development_api.entity.RoomsEntity;

public interface RoomsRepository extends JpaRepository<RoomsEntity, Integer> {

    List<RoomsEntity> findAllByHomeId(Integer homeId);

}
