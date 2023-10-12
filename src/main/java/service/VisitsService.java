package service;

import entity.Guest;
import entity.SportOffice;


public interface VisitsService {
    void addVisits(Guest guest, SportOffice sportOffice);
}
