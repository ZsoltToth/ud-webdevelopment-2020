package hu.unideb.webdev.exceptions;

import hu.unideb.webdev.model.Address;
import lombok.Data;

@Data
public class UnknownAddressException extends Exception {

    private Address address;

    public UnknownAddressException(Address address) {
        this.address = address;
    }

    public UnknownAddressException(String message, Address address) {
        super(message);
        this.address = address;
    }

    public UnknownAddressException(String message) {
        super(message);
    }
}
