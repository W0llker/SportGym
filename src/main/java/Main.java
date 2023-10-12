import config.ApplicationContext;
import entity.Address;
import entity.Employee;
import entity.Guest;
import entity.User;
import entity.enumentity.Status;
import repository.EmployeeDao;
import repository.hibernate.EmployeeHibernate;
import repository.hibernate.GuestHibernate;
import repository.hibernate.UserHibernate;
import service.GuestService;
import service.UserService;
import service.VisitsService;
import service.impl.GuestServiceImpl;
import service.impl.UserServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;

/*
1.1. Добавьте информацию об адресе у клиента. При этом эта информация должна находится в качестве другого объекта, но в одной таблиц с пользователем (поля для адреса: город, улица, номер дома, почтовый индекс)
2. Сделайте sequence для идентификатора. В дальнейшем будем
3. Создайте сущность, по которой будут выбираться помещения в к
оторые будут входить не более 15 человек. (@Subselect). Отобразите стоимость этих помещений.
4. Создайте сущность премиум клиентов. (@Where используйте).
5. Создайте таблицу Посещений с полями (id, client_id, дата посещения, потраченная сумма, id услуги).
6. Выполните метод, который будет заполнять эту таблицу при каждом посещении клиентом (пока без связей).
7. Заполните эту таблицу с использованием этого метода
 */
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl(new UserHibernate());

//        SportOfficeHibernate sportOfficeDao = new SportOfficeHibernate();
//        SportOffice sportOffice = new SportOffice();
//        sportOffice.setInventoryNumber("1235");
//        sportOffice.setStatusSportOffice(StatusSportOffice.ACTIVE);
//        sportOffice.setName("Баскет");
//        sportOffice.setPriceInHour(new BigDecimal(250));
//        sportOffice.setMaxPeople(20);

//        SportOfficeService sportOfficeService = ApplicationContext.getInstance().getSportOfficeService();
//        System.out.println(sportOfficeService.findSmallPremises());

//        System.out.println(userService.getUsers());

//        System.out.println(sportOfficeService.getPriceOnePerson(3l));
//        System.out.println(sportOfficeService.findById(3l));
//        System.out.println(sportOfficeService.getAll());

//        VisitsService visitsService = ApplicationContext.getInstance().getVisitsService();
//        visitsService.addVisits(1l,4l);

        Employee employee = new Employee(LocalDate.now(),null,"Начальник",new BigDecimal(500));
        EmployeeDao employeeDao = new EmployeeHibernate();
        employeeDao.add(employee);

//        Guest guest = new Guest();
//        guest.setName("Никита");
//        guest.setSurName("Вдовенков");
//        guest.setNumberPhone("33981290");
//        guest.setStatus(Status.PREMIUM);
//        guest.setAmount(new BigDecimal(400));
//        guest.setAddress(new Address("Гомель","км","3р","454"));
//        guest.setFirstDate(LocalDate.now());
//        guest.setLastDate(LocalDate.now());
//        GuestService guestService = new GuestServiceImpl(new GuestHibernate());
//        guestService.add(guest);

        System.out.println(userService.findUserPremium());
    }
}
