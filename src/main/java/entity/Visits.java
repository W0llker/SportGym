package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private Long clientId;
    private LocalDate dateVisits;
    private BigDecimal money;
    private Long idSportOffice;

    public Visits(Long clientId, LocalDate dateVisits, BigDecimal money, Long idSportOffice) {
        this.clientId = clientId;
        this.dateVisits = dateVisits;
        this.money = money;
        this.idSportOffice = idSportOffice;
    }
}
