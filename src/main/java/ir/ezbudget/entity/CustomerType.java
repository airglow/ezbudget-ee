package ir.ezbudget.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerType {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String title;

}
