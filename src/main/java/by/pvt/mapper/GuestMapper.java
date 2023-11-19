package by.pvt.mapper;

import by.pvt.dto.guest.GuestRequest;
import by.pvt.dto.guest.GuestResponse;
import by.pvt.entity.Guest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestMapper extends SupperMapper<Guest, GuestRequest, GuestResponse>{
}
