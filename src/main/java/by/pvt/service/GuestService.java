package by.pvt.service;

import by.pvt.dto.guest.GuestRequest;
import by.pvt.dto.guest.GuestResponse;

import java.util.List;

public interface GuestService {
    GuestResponse add(GuestRequest guest);
    void remove(Long id);
    GuestResponse findById(Long id);
    List<GuestResponse> getAllGuest();
}
