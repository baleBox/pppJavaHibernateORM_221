package hiber;

import hiber.config.AppConfig;
import hiber.model.*;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW", 5)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("KIA", 3)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("SUBARU", 6)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("NISSAN", 2)));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println();
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        List<User> userCar = userService.getUsersByCar("SUBARU", 6);
        for (User user : userCar) {
            System.out.println();
            System.out.println("Машиной " + user.getCar().getModel() + " " + user.getCar().getSeries() + " владеет:");
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}
