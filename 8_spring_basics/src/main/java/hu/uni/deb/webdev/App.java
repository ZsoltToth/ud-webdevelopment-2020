package hu.uni.deb.webdev;

import hu.uni.deb.webdev.dao.UserDao;
import hu.uni.deb.webdev.dao.UserDaoImpl;
import hu.uni.deb.webdev.model.User;
import hu.uni.deb.webdev.service.GreetingsService;
import hu.uni.deb.webdev.service.GreetingsServiceImpl;
import hu.uni.deb.webdev.service.expcetion.UnknownUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class App implements CommandLineRunner
{
    @Autowired
    ApplicationContext context;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println( "Hello World!" );
        System.out.println(context.getBean("course"));
        UserDao dao = context.getBean(UserDao.class);
        dao.createUser(new User("John Doe", "john", 42));
        GreetingsService service = context.getBean(GreetingsService.class);
        try {
            service.welcome("john");
            service.welcome("jane");
        }catch (UnknownUserException e){
            log.info("Service Exception: {}", e.getMessage());
        }
    }
}