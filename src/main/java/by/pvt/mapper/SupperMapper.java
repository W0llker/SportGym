package by.pvt.mapper;

import by.pvt.dto.activities.ActivitiesRequest;
import by.pvt.dto.activities.ActivitiesResponse;
import by.pvt.entity.Activities;

public interface SupperMapper<E,REQ,RESP>{
    E createEntity(REQ req);

    RESP createResponse(E client);
}
