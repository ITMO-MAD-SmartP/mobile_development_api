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
@IdClass(UserIdHomeIdPair.class)
public class UserIdHomeIdPair {

    @Id
    @Column(name = "user_id")
    protected Integer userId;

    @Id
    @Column(name = "home_id")
    protected Integer homeId;

}
