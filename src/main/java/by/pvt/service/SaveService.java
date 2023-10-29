package by.pvt.service;

import by.pvt.entity.Save;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface SaveService {
    void save(Save save);

    void delete(Long id);

    List<Save> getAll();

    Page<Save> getAll(int size, int page);

    List<Save> getByData(LocalDate start);

    Save findById(Long id);
}
