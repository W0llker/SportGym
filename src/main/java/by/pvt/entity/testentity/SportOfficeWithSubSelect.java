package by.pvt.entity.testentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Subselect;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Subselect("select so.id as id, so.name as name,so.inventory_number as inventory,so.price_in_hour as price from sportcentersch.sport_office so where so.max_people <= 15")
public class SportOfficeWithSubSelect {
    @Id
    public Long id;
    private String name;
    private String inventory;
    private BigDecimal price;
}
