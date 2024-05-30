package ru.itmo.mobile_development_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.mobile_development_api.entity.HomesEntity;

public interface HomesRepository extends JpaRepository<HomesEntity, Integer> {

    List<HomesEntity> findAllByOwnerId(Integer ownerId);

}
