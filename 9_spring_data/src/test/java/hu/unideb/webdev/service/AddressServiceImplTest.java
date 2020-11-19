package hu.unideb.webdev.service;

import hu.unideb.webdev.dao.AddressDao;
import hu.unideb.webdev.exceptions.UnknownCountryException;
import hu.unideb.webdev.model.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTest {

    @InjectMocks
    private AddressServiceImpl service;
    @Mock
    private AddressDao dao;

    @Test
    public void testRecordAddress() throws UnknownCountryException {
        Address address = getAddress();

        service.recordAddress(address);

        verify(dao,times(1)).createAddress(address);
    }

    @Test
    void testRecordAddressWithUnknonwCountry() throws UnknownCountryException {
        doThrow(UnknownCountryException.class).when(dao).createAddress(any());

        assertThrows(UnknownCountryException.class, ()->{
            service.recordAddress(getAddress());
        });
    }

    @Test
    void testReadAllAddresses(){
        when(dao.readAll()).thenReturn(getDefaultAddresses());

        Collection<Address> actual = service.getAllAddress();

        assertThat(getDefaultAddresses(), is(actual));
    }

    @Test
    void testReadAddressesFromUknonwCity(){
        when(dao.readAll()).thenReturn(getDefaultAddresses());
        final String unknonwCityName = "UnknonwCity";

        Collection<Address> actual = service.getAddressInCity(unknonwCityName);

        assertThat(Collections.emptyList(), is(actual));

    }

    private Address getAddress() {
        return new Address(
                "address1",
                "address2",
                "district",
                "UnknownCity",
                "Algeria_1234",
                "postalCode",
                "phone"
        );
    }

    private Collection<Address> getDefaultAddresses(){
        return Arrays.asList(
                new Address(
                        "address1",
                        "address2",
                        "district",
                        "Atlantis",
                        "Greece",
                        "postalCode",
                        "phone"
                ),
                new Address(
                        "address10",
                        "address20",
                        "district",
                        "Atlantis",
                        "Greece",
                        "postalCode",
                        "phone"
                ),
                new Address(
                        "address1",
                        "address2",
                        "district",
                        "Debrecen",
                        "Hungary",
                        "postalCode",
                        "phone"
                ));
    }
}