package hu.unideb.webdev.controller;

import hu.unideb.webdev.controller.dto.AddressDto;
import hu.unideb.webdev.controller.dto.AddressRecordResquestDto;
import hu.unideb.webdev.exceptions.UnknownCountryException;
import hu.unideb.webdev.model.Address;
import hu.unideb.webdev.service.AddressService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "World", required = false) String name){
        return String.format("Hello %s!", name);
    }

    @ApiOperation("Say Hello from Path")
    @GetMapping("/hello/{name}")
    public String helloPath(@PathVariable("name") String name){
        return String.format("Hello %s!", name);
    }


    @GetMapping("/address")
    public Collection<AddressDto> listAddresses(){
        return service.getAllAddress()
                .stream()
                .map(model -> AddressDto.builder()
                    .address(model.getAddress())
                    .address2(model.getAddress2())
                    .district(model.getDistrict())
                    .city(model.getCity())
                    .country(model.getCountry())
                    .build())
                .collect(Collectors.toList());
    }


    @PostMapping("/address")
    public void record(@RequestBody AddressRecordResquestDto requestDto) {
        try {
            service.recordAddress(new Address(
                    requestDto.getAddress(),
                    requestDto.getAddress2(),
                    requestDto.getDistrict(),
                    requestDto.getCity(),
                    requestDto.getCountry(),
                    requestDto.getPostalCode(),
                    requestDto.getPhone()
            ));
        } catch (UnknownCountryException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
