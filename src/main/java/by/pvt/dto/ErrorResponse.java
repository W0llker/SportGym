package by.pvt.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private Integer code;
}
