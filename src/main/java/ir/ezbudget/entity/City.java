package ir.ezbudget.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String name;

    @NonNull
    @ManyToOne
    private Province province;

    @OneToMany(mappedBy = "city")
    private List<Customer> customers;

}
