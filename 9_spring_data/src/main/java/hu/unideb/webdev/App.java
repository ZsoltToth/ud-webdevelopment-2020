package hu.unideb.webdev;

import hu.unideb.webdev.dao.AddressRepository;
import hu.unideb.webdev.dao.CityRepository;
import hu.unideb.webdev.dao.CountryRepository;
import hu.unideb.webdev.dao.entity.CityEntity;
import hu.unideb.webdev.dao.entity.CountryEntity;
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
 * @see ${project.basedir}/src/main/resources/sql/sakila.sh
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
        CountryRepository countryRepository = context.getBean(CountryRepository.class);
//        repository.save(new CountryEntity(0,"Vadia",new Timestamp((new Date()).getTime())));
//        repository.findAll().forEach(System.out::println);
//        System.out.println("--------------------");
//        repository.findByName("Vadia").stream().forEach(System.out::println);
        CityRepository repository = context.getBean(CityRepository.class);
        repository.findAll().forEach(System.out::println);
        repository.save(new CityEntity(0,
                "El Dorado",
                countryRepository.findById(51).get(),
                new Timestamp((new Date()).getTime())
        ));

        AddressRepository addressRepository = context.getBean(AddressRepository.class);
        addressRepository.findAll().forEach(System.out::println);
    }
}
