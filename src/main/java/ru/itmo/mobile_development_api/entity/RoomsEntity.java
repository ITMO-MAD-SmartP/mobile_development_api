package ru.itmo.mobile_development_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "rooms")
public class RoomsEntity {

    @Id
    @Column(name = "id")
    private Integer id;


    @Column(name = "home_id")
    private Integer homeId;


}
