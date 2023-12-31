package by.pvt.entity;

import by.pvt.entity.enumentity.Status;
import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Entity
//@DiscriminatorColumn(name = "Type_of_entity")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@ToString
@Table(name = "user",schema = "sportcentersch")
public abstract class User implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_client", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client")
    private Long id;
    private String name;
    @Column(name = "sur_name")
    private String surName;
    private Integer age;
    @Column(name = "number_phone")
    private String numberPhone;
    @Embedded
    private Address address;

    public User(String name, String surName, Integer age, String numberPhone, LocalDate lastDate, Status status, BigDecimal amount, Address address) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.numberPhone = numberPhone;
        this.address = address;
    }
}
