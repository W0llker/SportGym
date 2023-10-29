package by.pvt.entity;

import by.pvt.entity.enumentity.Status;
import lombok.Data;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "save", schema = "sportcentersch")
public class Save {
    @Id
    @SequenceGenerator(name = "save-seq", sequenceName = "seq-save", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "save-seq")
    private Long id;
    private BigDecimal discounts;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
}
