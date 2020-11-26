package hu.unideb.webdev.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String address;
    private String address2;
    private String district;
    private String city;
    private String country;
}
