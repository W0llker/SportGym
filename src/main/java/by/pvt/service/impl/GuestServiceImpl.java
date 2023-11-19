package by.pvt.service.impl;

import by.pvt.dto.guest.GuestRequest;
import by.pvt.dto.guest.GuestResponse;
import by.pvt.mapper.GuestMapper;
import by.pvt.repository.GuestDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.pvt.service.GuestService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {
    @Autowired
    private final GuestDao guestDao;
    private final GuestMapper guestMapper;

    @Override
    public GuestResponse add(GuestRequest guest) {
        return guestMapper.createResponse(guestDao.save(guestMapper.createEntity(guest)));
    }

    @Override
    public void remove(Long id) {
        guestDao.deleteById(id);
    }

    @Override
    public GuestResponse findById(Long id) {
        var guest = Optional.of(guestDao.findById(id).orElseThrow(() -> new RuntimeException("Нету такого гостя с таким id" + id))).get();
        return guestMapper.createResponse(guest);
    }

    @Override
    public List<GuestResponse> getAllGuest() {
        return guestDao.findAll().stream().map(guestMapper::createResponse).collect(Collectors.toList());
    }
}
