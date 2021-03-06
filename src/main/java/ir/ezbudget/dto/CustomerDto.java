package ir.ezbudget.dto;

import ir.ezbudget.entity.City;
import ir.ezbudget.entity.Customer;
import ir.ezbudget.entity.CustomerType;
import ir.ezbudget.entity.enums.CustomerStatus;
import ir.ezbudget.entity.enums.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerDto {

    private String code;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String cellPhoneNumber;
    private String fax;
    private String email;
    private String address;
    private Date createdAt;
    private Gender gender;
    private CustomerStatus status;
    private CustomerType type;
    private City city;

    public static Customer dtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCode(customerDto.getCode());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setCellPhoneNumber(customerDto.getCellPhoneNumber());
        customer.setFax(customerDto.getFax());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        customer.setCreatedAt(new Date());
        customer.setGender(customerDto.getGender());
        customer.setStatus(customerDto.getStatus());
        customer.setType(customerDto.getType());
        customer.setCity(customerDto.getCity());

        return customer;
    }

    public static CustomerDto entityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode(customer.getCode());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setCellPhoneNumber(customer.getCellPhoneNumber());
        customerDto.setFax(customer.getFax());
        customerDto.setEmail(customer.getEmail());
        customerDto.setAddress(customer.getAddress());
        customerDto.setCreatedAt(customer.getCreatedAt());
        customerDto.setGender(customer.getGender());
        customerDto.setStatus(customer.getStatus());
        customerDto.setType(customer.getType());
        customerDto.setCity(customer.getCity());

        return customerDto;
    }

}
