package ru.itmo.mobile_development_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.mobile_development_api.entity.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
}
