package hu.unideb.webdev;

import hu.unideb.webdev.exceptions.UnknownCountryException;
import hu.unideb.webdev.model.Address;
import hu.unideb.webdev.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Run -> Configuration -> Environment Variables
 *  - DB_HOST localhost /127.0.0.1
 *  - DB_PORT 3306
 *  - DB_NAME sakila
 *  - DB_USER root
 *  - DB_PASS secret
 *
 *  Example configuration
 * @see {project.basedir}/src/main/resources/sql/sakila.sh
 */
@Slf4j
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println( "Hello World!" );
        AddressService service = context.getBean(AddressService.class);
//        dao.readAll().stream().forEach(System.out::println);
        Address model = new Address(
                "address1",
                "address2",
                "district",
                "UnknownCity",
                "Algeria",
                "postalCode",
                "phone"
                );
        try {
//            service.recordAddress(model);
            service.deleteAddress(model);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
