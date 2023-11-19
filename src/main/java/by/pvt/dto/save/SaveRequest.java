package by.pvt.dto.save;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SaveRequest {
    @NotBlank
    private String name;
    @Min(1)
    private BigDecimal discounts;
    @Future
    private LocalDate startDate;
    @Future
    private LocalDate endDate;
    private StatusSave status;
    @AssertTrue
    private boolean isDateEnd() {
        return endDate.isAfter(startDate);
    }
}
