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
@Table(name = "homes")
public class HomesEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "owner_id")
    private Integer ownerId;

}
