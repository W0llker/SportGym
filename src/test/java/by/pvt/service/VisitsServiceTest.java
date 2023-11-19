package by.pvt.service;

import by.pvt.repository.GuestDao;
import by.pvt.repository.SportOfficeDao;
import by.pvt.repository.VisitsDao;
import by.pvt.service.impl.VisitsServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class VisitsServiceTest {
    @InjectMocks
    protected VisitsServiceImpl visitsService;
    @Mock
    protected GuestDao guestDao;
    @Mock
    protected SportOfficeDao sportOfficeDao;
    @Mock
    protected VisitsDao visitsDao;
}
