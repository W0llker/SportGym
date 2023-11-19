package by.pvt.entity;

import by.pvt.dto.guest.Status;
import lombok.*;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;


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
public abstract class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "seq_client", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client")
    private Long id;
    private String name;
    @Column(name = "sur_name")
    private String surName;
    private String password;
    private Integer age;
    @Column(name = "number_phone")
    private String numberPhone;
    @Embedded
    private Address address;

    public User(String name, String surName, String password, Integer age, String numberPhone, Address address) {
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.age = age;
        this.numberPhone = numberPhone;
        this.address = address;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
