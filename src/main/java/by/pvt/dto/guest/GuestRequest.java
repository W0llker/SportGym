package by.pvt.dto.guest;

import by.pvt.dto.save.SaveRequest;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GuestRequest {
    private Long id;
    private String name;
    private String surName;
    private Integer age;
    private String numberPhone;
    private Status status;
}
