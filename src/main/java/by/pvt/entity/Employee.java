package by.pvt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "employee",schema = "sportcentersch")
@DiscriminatorValue(value = "employee")
public class Employee extends User {
    private LocalDate  startWork;
    private LocalDate dismissal;
    private String post;
    private BigDecimal salary;
}
