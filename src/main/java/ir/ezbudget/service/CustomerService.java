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

    public Long createCustomer(CustomerDto customerDto) {

        Customer customer = CustomerDto.dtoToEntity(customerDto);

        entityManager.persist(customer);

        return customer.getId();
    }

    public void deleteCustomer(Long id) {

        Customer customer = entityManager.find(Customer.class, id);

        if (customer == null) {
            throw new EntityNotFoundException();
        }

        entityManager.remove(customer);
    }

    public void updateCustomer(Long id, CustomerDto customerDto) {

        Customer currentCustomer = entityManager.find(Customer.class, id);

        if (currentCustomer == null) {
            throw new EntityNotFoundException();
        }

        Customer customer = CustomerDto.dtoToEntity(customerDto);
        customer.setId(currentCustomer.getId());

        entityManager.merge(customer);
    }

}
