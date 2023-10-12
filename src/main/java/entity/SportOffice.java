package entity;

import entity.enumentity.StatusSportOffice;
import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sport_office",schema = "sportcentersch")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "sportoffice")
public class SportOffice {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "max_people")
    private Integer maxPeople;
    @Column(name = "inventory_number", nullable = false)
    private String inventoryNumber;
    @Enumerated(EnumType.STRING)
    private StatusSportOffice statusSportOffice;
    @Column(name = "price_in_hour")
    private BigDecimal priceInHour;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "activities_id", nullable = false)
    private Activities activities;
    @OneToMany(mappedBy = "sportOffice", cascade = CascadeType.ALL)
    private List<Visits> visits;

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public void setStatusSportOffice(StatusSportOffice statusSportOffice) {
        this.statusSportOffice = statusSportOffice;
    }

    public void setPriceInHour(BigDecimal priceInHour) {
        this.priceInHour = priceInHour;
    }

    private void setMaxPeople(String maxPeople) {
        this.maxPeople = Integer.parseInt(maxPeople);
    }

    private void setStatusSportOffice(String statusSportOffice) {
        this.statusSportOffice = StatusSportOffice.valueOf(statusSportOffice);
    }

    private void setPriceInHour(String priceInHour) {
        this.priceInHour = new BigDecimal(priceInHour);
    }
}
