package by.pvt.entity;

import by.pvt.dto.save.StatusSave;
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
    @Column(unique = true)
    private String name;
    private BigDecimal discounts;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private StatusSave status;
}
