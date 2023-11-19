package by.pvt.mapper;

import by.pvt.dto.save.SaveRequest;
import by.pvt.dto.save.SaveResponse;
import by.pvt.entity.Save;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaveMapper extends SupperMapper<Save, SaveRequest, SaveResponse>{
}
