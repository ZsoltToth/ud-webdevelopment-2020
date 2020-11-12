package hu.unideb.webdev.dao.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "city", schema = "sakila")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="city_id")
    private int id;

    @Column(name="city")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @Column(name="last_update")
    private Timestamp lastUpdate;
}
