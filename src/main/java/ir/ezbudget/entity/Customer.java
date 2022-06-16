package ir.ezbudget.entity;

import ir.ezbudget.entity.enums.CustomerStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Customer {

    @Id
    private Long id;

    private String code;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String cellPhoneNumber;

    private String fax;

    @Pattern(regexp = "/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/")
    private String email;

    private String address;

    private String gender;

    private Date createdAt;

    private CustomerStatus status;

    @ManyToOne
    private CustomerType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

}
