package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activities",schema = "sportcentersch")
public class Activities {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String cost;
    @OneToMany(mappedBy = "activities")
    private List<SportOffice> sportOffice;

}
