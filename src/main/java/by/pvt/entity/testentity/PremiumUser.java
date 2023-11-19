package by.pvt.entity.testentity;

import by.pvt.dto.guest.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Subselect("select so.id as id, so.name as name,so.sur_name as surName,g.status as status from sportcentersch.user so join sportcentersch.guest g ON g.id = so.id")
@Where(clause = "status = 'PREMIUM'")
public class PremiumUser {
    @Id
    private Long id;
    private String name;
    private String surName;
    @Enumerated(EnumType.STRING)
    private Status status;
}
