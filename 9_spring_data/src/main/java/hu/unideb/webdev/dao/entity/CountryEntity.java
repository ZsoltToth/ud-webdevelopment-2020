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
@Table(name = "country", schema = "sakila")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int id;

    @Column(name="country")
    private String name;

    @Column(name ="last_update")
    private Timestamp lastUpdate;
}
