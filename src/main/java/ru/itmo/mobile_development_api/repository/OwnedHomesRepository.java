package ru.itmo.mobile_development_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.mobile_development_api.entity.OwnedHomesEntity;
import ru.itmo.mobile_development_api.entity.UserIdHomeIdPair;

public interface OwnedHomesRepository extends JpaRepository<OwnedHomesEntity, UserIdHomeIdPair> {
}
