package entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "visits",schema = "sportcentersch")
public class Visits {
    @Id
    @SequenceGenerator(name = "seq_visit", sequenceName = "visit_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_visit")
    private Long id;
    @ManyToOne()
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "guest_id")
    private Guest guest;
    private LocalDate dateVisits;
    @ManyToOne()
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "sportOffice_id")
    private SportOffice sportOffice;
    private BigDecimal amount;
}
