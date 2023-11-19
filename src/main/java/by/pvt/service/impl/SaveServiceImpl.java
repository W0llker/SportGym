package by.pvt.service.impl;

import by.pvt.dto.DeleteOrFindDto;
import by.pvt.dto.guest.GuestResponse;
import by.pvt.dto.save.SaveRequest;
import by.pvt.dto.save.SaveResponse;
import by.pvt.dto.save.StatusSave;
import by.pvt.entity.Guest;
import by.pvt.entity.Save;
import by.pvt.dto.guest.Status;
import by.pvt.mapper.GuestMapper;
import by.pvt.mapper.SaveMapper;
import by.pvt.repository.GuestDao;
import by.pvt.repository.SaveDao;
import by.pvt.service.SaveService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaveServiceImpl implements SaveService {
    private final SaveDao saveDao;
    private final GuestDao guestDao;
    private final GuestMapper guestMapper;
    private final SaveMapper saveMapper;

    @Autowired
    public SaveServiceImpl(SaveDao saveDao, GuestDao guestDao, GuestMapper guestMapper, SaveMapper saveMapper) {
        this.saveDao = saveDao;
        this.guestDao = guestDao;
        this.guestMapper = guestMapper;
        this.saveMapper = saveMapper;
    }

    @Transactional
    @Override
    public SaveResponse save(SaveRequest save) {
        if (save.getStatus() == null)
            save.setStatus(StatusSave.ACTIVITIES);
        return saveMapper.createResponse(saveDao.save(saveMapper.createEntity(save)));
    }

    @Override
    public void delete(Long id) {
        saveDao.deleteById(id);
    }

    @Transactional
    @Override
    public SaveResponse findById(Long id) {
        return saveMapper.createResponse(Optional.of(saveDao.findById(id).orElseThrow()).get());
    }

    @Override
    @Transactional
    public GuestResponse addSaveByUser(Long idUser, DeleteOrFindDto dto) {
        Guest guest = Optional.of(guestDao.findById(idUser).orElseThrow(() -> new RuntimeException("Данного клиента нету"))).get();
        Save save = Optional.of(saveDao.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Данного клиента нету"))).get();
        if (guest.getSave() == null && guest.getStatus().equals(Status.PREMIUM)) {
            guest.setSave(save);
            guestDao.save(guest);
            return guestMapper.createResponse(guest);
        }
        throw new RuntimeException("Пользователь не может получить скидку");
    }

    @Override
    public List<SaveResponse> getAll() {
        return saveDao.findAll().stream().map(saveMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public List<SaveResponse> getByData(LocalDate start) {
        return saveDao.findByStartDate(start).stream().map(saveMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public Page<Save> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return saveDao.findAll(pageable);
    }
}
