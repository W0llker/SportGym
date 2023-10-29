import by.pvt.config.SpringConfig;
import by.pvt.entity.*;
import by.pvt.service.GuestService;
import by.pvt.service.SaveService;
import by.pvt.service.VisitsService;
import by.pvt.service.impl.GuestServiceImpl;
import by.pvt.entity.enumentity.StatusSportOffice;
import by.pvt.repository.EmployeeDao;
import by.pvt.service.UserService;
import by.pvt.service.impl.SaveServiceImpl;
import by.pvt.service.impl.UserServiceImpl;
import by.pvt.service.impl.VisitsServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;

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
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        SaveService service = applicationContext.getBean(SaveService.class);
        VisitsService visitsService = applicationContext.getBean(VisitsService.class);
        visitsService.addVisits(3l,7l);
        // TODO: 20.10.2023 Spring Data
//        Save save = new Save();
//        save.setDiscounts(new BigDecimal(250));
//        save.setEndDate(LocalDate.now());
//        save.setStartDate(LocalDate.now());
//        System.out.println(service.getByData(LocalDate.now()));

        // TODO: 20.10.2023 Пагинация
//        Page<Save> page = service.getAll(2,0);
//        page.stream().forEach(System.out::println);
//        service.save(save);
//        GuestService g = applicationContext.getBean(GuestServiceImpl.class);
//        System.out.println(g.getAllGuest());

    }
    private static void addEmploy() {
//        EmployeeDao employeeDao = new EmployeeHibernate();
        Employee employee = new Employee();
        employee.setName("Санька");
        employee.setSurName("Vdovenkor");
        employee.setAge(15);
        employee.setPost("Начальник");
        employee.setDismissal(LocalDate.now());
        employee.setStartWork(LocalDate.now());
        employee.setSalary(new BigDecimal(7500));
//        employeeDao.add(employee);
    }
}
