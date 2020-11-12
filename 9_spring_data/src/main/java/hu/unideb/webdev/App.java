package hu.unideb.webdev;

import hu.unideb.webdev.dao.AddressDao;
import hu.unideb.webdev.dao.AddressRepository;
import hu.unideb.webdev.dao.CityRepository;
import hu.unideb.webdev.dao.CountryRepository;
import hu.unideb.webdev.dao.entity.CityEntity;
import hu.unideb.webdev.dao.entity.CountryEntity;
import hu.unideb.webdev.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

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
        AddressDao dao = context.getBean(AddressDao.class);
//        dao.readAll().stream().forEach(System.out::println);
        Address model = new Address(
                "address1",
                "address2",
                "district",
                "Batna",
                "Algeria",
                "postalCode",
                "phone"
                );
        dao.createAddress(model);
    }
}
