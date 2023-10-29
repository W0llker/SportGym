package by.pvt.service.impl;

import by.pvt.dto.activities.ActivitiesRequest;
import by.pvt.dto.activities.ActivitiesResponse;
import by.pvt.mapper.MapperActivitiesEntity;
import by.pvt.repository.ActivitiesDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.pvt.service.ActivitiesService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {
    private final ActivitiesDao activitiesDao;
    private MapperActivitiesEntity mapper;

    @Autowired
    public ActivitiesServiceImpl(ActivitiesDao activitiesDao, MapperActivitiesEntity mapper) {
        this.activitiesDao = activitiesDao;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ActivitiesResponse add(ActivitiesRequest activities) {
        return mapper.createResponse(activitiesDao.save(mapper.createEntity(activities)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        activitiesDao.deleteById(id);
    }

    @Override
    public List<ActivitiesResponse> getAll() {
        return activitiesDao.findAll().stream().map(mapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public ActivitiesResponse findById(Long id) {
        var activities = Optional.of(activitiesDao.findById(id).orElseThrow(() -> new RuntimeException("Нету пользователя с таким id " + id)));
        return mapper.createResponse(activities.get());
    }
}
