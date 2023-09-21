import config.ApplicationContext;
import entity.Status;
import entity.User;
import service.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        UserService userService = ApplicationContext.getInstance().getUserService();
        System.out.println(userService.getUsers());
//        userService.addUser(new User(1l,"Никита","Вдовенков",21,"+375445139012", LocalDate.now(), Status.ACTIVE,new BigDecimal(500)));
//        userService.addUser(new User(4l,"Никита","Вдовенков",21,"+375445139012", LocalDate.now(), Status.BLOCKED,new BigDecimal(500)));
        System.out.println(userService.findUser(4l));
    }
}
