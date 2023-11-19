package by.pvt.entity;

import by.pvt.dto.guest.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@DiscriminatorValue(value = "guest")
@Entity
@Table(name = "guest",schema = "sportcentersch")
public class Guest extends User {
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "last_date")
    private LocalDate lastDate;
    @Column(name = "first_date")
    private LocalDate firstDate;
    private BigDecimal amount;
    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY)
    private List<Visits> visits;
    @ManyToOne
    private Save save;

}
