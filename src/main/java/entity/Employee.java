package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee",schema = "sportcentersch")
@DiscriminatorValue(value = "employee")
public class Employee extends User {
    private LocalDate  startWork;
    private LocalDate dismissal;
    private String post;
    private BigDecimal salary;
}
