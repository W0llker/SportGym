package by.pvt.mapper;

import by.pvt.dto.activities.ActivitiesRequest;
import by.pvt.dto.activities.ActivitiesResponse;
import by.pvt.entity.Activities;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface MapperActivitiesEntity extends SupperMapper<Activities,ActivitiesRequest,ActivitiesResponse>{
}
