package by.pvt.dto.guest;

import by.pvt.dto.save.SaveResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GuestResponse {
    private Long id;
    private String name;
    private String surName;
    private Integer age;
    private String numberPhone;
    private SaveResponse save;
}
