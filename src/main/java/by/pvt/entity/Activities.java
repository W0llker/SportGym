package by.pvt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activities", schema = "sportcentersch")
public class Activities {
    @Id
    @SequenceGenerator(name = "seq_activities", sequenceName = "activities_seq", allocationSize = 1, schema = "sportcentersch")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_activities")
    private Long id;
    private String name;
    private String cost;
    @OneToMany(mappedBy = "activities")
    private List<SportOffice> sportOffice;

}
