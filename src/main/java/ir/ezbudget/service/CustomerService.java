package ir.ezbudget.service;

import ir.ezbudget.dto.CustomerDto;
import ir.ezbudget.entity.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    public CustomerDto findCustomerById(Long id) {

        Customer customer = entityManager.find(Customer.class, id);

        if (customer == null) {
            throw new EntityNotFoundException();
        }

        return CustomerDto.entityToDto(customer);
    }

    public List<CustomerDto> allCustomers() {

        List<Customer> customers = entityManager.createQuery("from Customer c", Customer.class).getResultList();

        return customers.stream().map(CustomerDto::entityToDto).toList();
    }

    public Long createCustomer(CustomerDto customerDao) {

        Customer customer = CustomerDto.dtoToEntity(customerDao);

        entityManager.persist(customer);

        return customer.getId();
    }

}
