package by.pvt.service;

import by.pvt.dto.DeleteOrFindDto;
import by.pvt.dto.guest.GuestResponse;
import by.pvt.dto.save.SaveRequest;
import by.pvt.dto.save.SaveResponse;
import by.pvt.entity.Save;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface SaveService {
    SaveResponse save(SaveRequest save);

    void delete(Long id);

    List<SaveResponse> getAll();

    Page<Save> getAll(int size, int page);

    List<SaveResponse> getByData(LocalDate start);
    GuestResponse addSaveByUser(Long idUser, DeleteOrFindDto dto);

    SaveResponse findById(Long id);
}
