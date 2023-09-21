package entity;

import entity.enumentity.StatusSportOffice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sport_office",schema = "sportcentersch")
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
