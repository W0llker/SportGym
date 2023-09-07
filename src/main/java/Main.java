import config.ApplicationContext;
import repository.hibernate.SportOfficeHibernate;
import service.SportOfficeService;
import service.UserService;


public class Main {
    public static void main(String[] args) {
        UserService userService = ApplicationContext.getInstance().getUserService();
        SportOfficeHibernate sportOfficeDao = new SportOfficeHibernate();
//        SportOffice sportOffice = new SportOffice();
//        sportOffice.setInventoryNumber("1235");
//        sportOffice.setStatusSportOffice(StatusSportOffice.ACTIVE);
//        sportOffice.setName("Баскет");
//        sportOffice.setPriceInHour(new BigDecimal(250));
//        sportOffice.setMaxPeople(20);
//        sportOfficeDao.add(sportOffice);
//        sportOfficeDao.addAndUpdate(3l,"ИЗМН1225");
//        sportOfficeDao.edit(3l,"maxPeople","43");
        SportOfficeService sportOfficeService = ApplicationContext.getInstance().getSportOfficeService();
        System.out.println(sportOfficeService.getPriceOnePerson(3l));
        System.out.println(sportOfficeService.findById(3l));
        System.out.println(sportOfficeService.getAll());
    }
}
