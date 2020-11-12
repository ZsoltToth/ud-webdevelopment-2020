package hu.unideb.webdev.dao.entity;

import lombok.*;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address", schema = "sakila")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private int id;

    @Column
    private String address;

    @Column
    private String address2;

    @Column
    private String district;

    @ManyToOne
    @JoinColumn(name="city_id")
    private CityEntity city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column
    private String phone;

    @Column(columnDefinition = "geometry")
    private Point location;
    @Column(name="last_update")
    private Timestamp lastUpdate;

}
