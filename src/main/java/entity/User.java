package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user",schema = "sportcentersch")
public class User implements Serializable {
    @Id
    private Long id;
    private String name;
    @Column(name = "sur_name")
    private String surName;
    private Integer age;
    @Column(name = "number_phone")
    private String numberPhone;
    @Column(name = "last_date")
    private LocalDate lastDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal amount;
}
