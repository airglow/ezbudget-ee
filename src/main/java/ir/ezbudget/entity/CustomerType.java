package ir.ezbudget.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerType {

    @Id
    private Long id;

    private String code;

    private String title;

}
