package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
//
        User user1 = new User("Zaur", "Tregulov", "zaur@gmail.com");
        Car car1 = new Car("Mazda", 6);

        User user2 = new User("German", "Savastyanov", "kata_noreply@gmail.com");
        Car car2 = new Car("BMW", 530);

        User user3 = new User("Alexandr", "Kabanov", "alexkaban@mail.ru");
        Car car3 = new Car("Peugeot", 308);

        User user4 = new User("Neil", "Alishev", "neil_alishev@yandex.ru");
        Car car4 = new Car("Mercedes", 211);

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("User's car = " + user.getCar());
            System.out.println();
        }

        System.out.println(userService.getUserByCar(new Car("Mazda", 6)));
        System.out.println(userService.getUserByCar(new Car("Peugeot", 308)));
        System.out.println(userService.getUserByCar(new Car("Mercedes", 211)));
        System.out.println(userService.getUserByCar(new Car("BMW", 530)));
    }
}
