package by.pvt.service.impl;

import by.pvt.entity.Save;
import by.pvt.repository.SaveDao;
import by.pvt.service.SaveService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SaveServiceImpl implements SaveService {
    private final SaveDao saveDao;

    @Autowired
    public SaveServiceImpl(SaveDao saveDao) {
        this.saveDao = saveDao;
    }

    @Transactional
    @Override
    public void save(Save save) {
        saveDao.save(save);
    }

    @Override
    public void delete(Long id) {
        saveDao.deleteById(id);
    }

    @Transactional
    @Override
    public Save findById(Long id) {
        Optional<Save> save = Optional.of(saveDao.findById(id).orElseThrow());
        return save.get();
    }

    @Override
    public List<Save> getAll() {
        return saveDao.findAll();
    }

    @Override
    public List<Save> getByData(LocalDate start) {
        return saveDao.findByStartDate(start);
    }

    @Override
    public Page<Save> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return saveDao.findAll(pageable);
    }
}
